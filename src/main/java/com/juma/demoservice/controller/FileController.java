package com.juma.demoservice.controller;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
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

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    @PostMapping("/file")
    public String addFile(@RequestParam("myfile") MultipartFile file, HttpSession session, Model model) throws IOException {

        String mylocation = System.getProperty("user.dir") + "/src/main/resources/static/";
        String filename = file.getOriginalFilename();

        File mySavedFile = new File(mylocation + filename);

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
            landmark.setScore(landmarkAnnotationsList.get(i).getScore());
            landmarks.add(landmark);
        }
        for (EntityAnnotation entityAnnotation : landmarkAnnotationsList){
            log.trace("Description {} and score {}",entityAnnotation.getDescription(), entityAnnotation.getScore());
        }
//        log.trace(response.getLandmarkAnnotationsList().toString());
        log.trace("Landmark list {}",landmarks);
        model.addAttribute("landmarks",landmarks);
//        User user = (User) session.getAttribute("loggedIn");
//        log.trace("User is {}",user );
//        com.midterm.exam.entity.File fileUpload = new com.midterm.exam.entity.File();
//        fileUpload.setFileName(myLink);
//
//        com.midterm.exam.entity.File byUserId = fileService.findByUserId(user);
//        if(byUserId != null){
//            byUserId.setFileName(myLink);
//            fileService.save(byUserId);
//            model.addAttribute("status","Document updated successfully!");
//        }else{
//            fileUpload.setUser(user);
//            fileService.save(fileUpload);
//            model.addAttribute("status","Document added successfully!");
//
//        }

//        model.addAttribute("userDetails",session.getAttribute("loggedIn"));



        return "landmark-result";
    }
}
