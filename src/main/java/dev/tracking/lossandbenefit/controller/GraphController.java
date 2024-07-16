package dev.tracking.lossandbenefit.controller;


import dev.tracking.lossandbenefit.dto.TransactionDto;
import dev.tracking.lossandbenefit.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/graphs")
public class GraphController {

    @Autowired
    GraphService graphService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionDto>> getTransactionsForGraph(
            @PathVariable Long userId,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate){
        LocalDateTime start =LocalDateTime.parse(startDate);
        LocalDateTime end = LocalDateTime.parse(endDate);
        List<TransactionDto> transactions =graphService.getTransactionsForUser(userId, start, end);
        return ResponseEntity.ok(transactions);
    }
}
