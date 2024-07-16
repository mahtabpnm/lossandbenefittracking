package dev.tracking.lossandbenefit.controller.view;
import dev.tracking.lossandbenefit.dto.TransactionDto;
import dev.tracking.lossandbenefit.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TransactionViewController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping({"/transactions", "/transactions/{userId}"})
    public String transactions(@PathVariable(required = false) Long userId, Model model) {
        if (userId == null) {
            model.addAttribute("error", "User Id is required");
            return "error";
        } else {
            List<TransactionDto> transactions = transactionService.getTransactionsByUserId(userId);
            model.addAttribute("transactions", transactions);
            return "transactions";
        }
    }
}