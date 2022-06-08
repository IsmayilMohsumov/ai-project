package com.juma.demoservice.controller;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.juma.demoservice.entity.Label;
import com.juma.demoservice.entity.Landmark;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class FileController {
    private final String LOCALHOST = "http://localhost:8888/";
    private final String HOME = System.getProperty("user.dir") + "/src/main/resources/static/";

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    @PostMapping("/file-landmark")
    public String checkImageByLandmark(@RequestParam("myfile") MultipartFile file, HttpSession session, Model model) throws IOException {

        if (file.isEmpty()){
            model.addAttribute("status","Please provide a picture");
            return "landmark-page";
        }
        model.addAttribute("status","");

        String filename = file.getOriginalFilename();

        File mySavedFile = new File(HOME + filename);

        InputStream inputStream = file.getInputStream();

        OutputStream outputStrea = new FileOutputStream(mySavedFile);

        int read = 0 ;
        byte [] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1){
            outputStrea.write(bytes, 0 , read);
        }

        String imageUrl =LOCALHOST + filename;
        Resource imageResource = this.resourceLoader.getResource(imageUrl);
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
                Feature.Type.LANDMARK_DETECTION);
        List<EntityAnnotation> landmarkAnnotationsList = response.getLandmarkAnnotationsList();

        List<Landmark> landmarks = new ArrayList<>();

        for (int i = 0; i <landmarkAnnotationsList.size() ; i++) {
            Landmark landmark = new Landmark();
            HashMap<String,Double> longAndLat = new HashMap<>();

            landmark.setDescription(landmarkAnnotationsList.get(i).getDescription());
            longAndLat.put("latitude", landmarkAnnotationsList.get(i).getLocations(0).getLatLng().getLatitude());
            longAndLat.put("longitude", landmarkAnnotationsList.get(i).getLocations(0).getLatLng().getLongitude());
            landmark.setLocations(longAndLat);
            landmark.setScore((int)(landmarkAnnotationsList.get(i).getScore()*100f));
            landmarks.add(landmark);
        }
        for (EntityAnnotation entityAnnotation : landmarkAnnotationsList){
            log.trace("Description {} and score {}",entityAnnotation.getDescription(), entityAnnotation.getScore());
        }
        log.trace("Landmark list {}",landmarks);
        model.addAttribute("landmarks",landmarks);

//        String address ="https://www.google.com/maps/@"+landmarks.get(0).getLocations().get("latitude").toString()+","+landmarks.get(0).getLocations().get("longitude").toString()+",18z";
        model.addAttribute("img",imageUrl);
//        model.addAttribute("address",address);


        return "landmark-result";
    }

    @PostMapping("/file-text")
    public String readTextFromImage(@RequestParam("myfile") MultipartFile file, HttpSession session, Model model) throws IOException {
        if (file.isEmpty()){
            model.addAttribute("status","Please provide a picture");
            return "text-detection";
        }
        String filename = file.getOriginalFilename();

        File mySavedFile = new File(HOME + filename);

        InputStream inputStream = file.getInputStream();

        OutputStream outputStrea = new FileOutputStream(mySavedFile);

        int read = 0 ;
        byte [] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1){
            outputStrea.write(bytes, 0 , read);
        }

        String imageUrl =LOCALHOST + filename;
        String text = this.cloudVisionTemplate.extractTextFromImage(this.resourceLoader.getResource(imageUrl));
        model.addAttribute("result",text);
        model.addAttribute("img",imageUrl);

        return "text-detection-result";
    }

    @PostMapping("/file-label")
    public String labelDetection(@RequestParam("myfile") MultipartFile file, HttpSession session, Model model) throws IOException {
        if (file.isEmpty()){
            model.addAttribute("status","Please provide a picture");
            return "label-detection";
        }
        String filename = file.getOriginalFilename();

        File mySavedFile = new File(HOME + filename);

        InputStream inputStream = file.getInputStream();

        OutputStream outputStrea = new FileOutputStream(mySavedFile);

        int read = 0 ;
        byte [] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1){
            outputStrea.write(bytes, 0 , read);
        }

        String imageUrl =LOCALHOST + filename;
        Resource imageResource = this.resourceLoader.getResource(imageUrl);
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
                Feature.Type.LABEL_DETECTION);
        List<EntityAnnotation> labelAnnotationsList = response.getLabelAnnotationsList();
        System.out.println(labelAnnotationsList);
        model.addAttribute("img",imageUrl);


        List<Label> labels = new ArrayList<>();

        for (int i = 0; i < labelAnnotationsList.size(); i++) {
            Label label= new Label();
            label.setDescription(labelAnnotationsList.get(i).getDescription());
            label.setScore((int)(labelAnnotationsList.get(i).getScore()*100f));
            labels.add(label);
        }
        model.addAttribute("labels",labels);

        return "label-detection-result";
    }
}
