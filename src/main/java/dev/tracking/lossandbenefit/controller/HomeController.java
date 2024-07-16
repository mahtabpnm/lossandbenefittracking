package dev.tracking.lossandbenefit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")

    public String home(){
        //This maps to src/main/resources/static/index.htm
        return "index";
    }
}

