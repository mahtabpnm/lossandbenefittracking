package dev.tracking.lossandbenefit.controller.view;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPasswordViewController {
    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }
}
