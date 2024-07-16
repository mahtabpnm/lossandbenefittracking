package dev.tracking.lossandbenefit.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
    @GetMapping("/Login")
    public String Login() {
        return "Login";
    }
    @GetMapping("/Transaction")
    public String Transaction() {
        return "Transaction";
    }
    @GetMapping("/categories")
    public String categories() {
        return "categories";
    }
    @GetMapping("/report")
    public String report() {
        return "report";
    }
    @GetMapping("/addTransaction")
    public String addTransaction() {
        return "addTransaction";
    }

    @GetMapping("/monthlyReport")
    public String monthlyReport() {
        return "monthlyReport";
    }

}
