package com.juma.demoservice.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Landmark {
    private String description;
    private float score;
    private HashMap<String,Double> locations;

}
