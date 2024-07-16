package dev.tracking.lossandbenefit.controller.view;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeViewController {

    @GetMapping("/")
    public String home(){
        //This maps to src/main/resources/static/index.htm
        return "index";
    }
}
