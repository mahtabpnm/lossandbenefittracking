package dev.tracking.lossandbenefit.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationViewController {
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
