package com.juma.demoservice.controller;


import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.Feature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class VisionController {
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    @RequestMapping("/getLabelDetection")
    public String getLabelDetection() {
        String imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Lion_d%27Afrique.jpg/290px-Lion_d%27Afrique.jpg";
        Resource imageResource = this.resourceLoader.getResource(imageUrl);
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
                Feature.Type.LABEL_DETECTION);
        return response.getLabelAnnotationsList().toString();

    }

    @GetMapping("/getLandmarkDetection")
    public String getLandmarkDetection() {
        String imageUrl = "https://www.parisinfo.com/var/otcp/sites/images/node_43/node_51/node_77884/node_77888/tour-eiffel-tour-eiffel-illumin%C3%A9e-depuis-champs-de-mars-%C3%A9clairage-dor%C3%A9-%7C-630x405-%7C-%C2%A9-sete-emeric-livinec/21230551-1-fre-FR/Tour-Eiffel-Tour-Eiffel-illumin%C3%A9e-depuis-Champs-de-Mars-%C3%A9clairage-dor%C3%A9-%7C-630x405-%7C-%C2%A9-SETE-Emeric-Livinec.jpg";
        Resource imageResource = this.resourceLoader.getResource(imageUrl);
        AnnotateImageResponse response = this.cloudVisionTemplate.analyzeImage(imageResource,
                Feature.Type.LANDMARK_DETECTION);
        log.trace(response.getLandmarkAnnotationsList().toString());
        return response.getLandmarkAnnotationsList().toString();
    }
    @GetMapping("/extractTextFromImage")
    public String extract() {
        String imageUrl = "http://localhost:8888/HCL.jpg";
        return this.cloudVisionTemplate.extractTextFromImage(this.resourceLoader.getResource(imageUrl));
    }
}
