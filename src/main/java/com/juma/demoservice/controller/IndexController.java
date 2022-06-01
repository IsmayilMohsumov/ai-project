package com.juma.demoservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
public class IndexController {

    @GetMapping("/")
    public String index(HttpSession httpSession){
        return "index";
    }

    @GetMapping("/index")
    public String login(Model model){

        return "users";
    }

    @GetMapping("/about")
    public String about(Model model){

        return "about-us";
    }

    @GetMapping("/start")
    public String start(Model model){

        return "start";
    }




    @GetMapping("/landmark")
    public String landmarkDetection(Model model){

        return "landmark-page";
    }

    @GetMapping("/text")
    public String textDetection(Model model){

        return "text-detection";
    }

    @GetMapping("/label")
    public String labelDetection(Model model){

        return "label-detection";
    }



    @GetMapping("/test")
    public String testForChart(Model model){

        return "test";
    }




    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) throws Exception {
        httpSession.invalidate();
        return "redirect:/login";
    }


}
