package dev.tracking.lossandbenefit.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class ReportController {

    @GetMapping("/download-report")
    public ResponseEntity<InputStreamResource> downloadReport() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);

        // Write sample data to CSV
        writer.println("ID,User,Category,Amount,Date,Benefit");
        writer.println("1,John Doe,Food,-50.0,2024-06-01,false");
        writer.println("2,John Doe,Transport,-20.0,2024-06-02,false");
        writer.println("3,John Doe,Entertainment,100.0,2024-06-03,true");
        writer.println("4,Jane Doe,Food,-30.0,2024-06-01,false");
        writer.println("5,Jane Doe,Transport,-10.0,2024-06-02,false");
        writer.println("6,Jane Doe,Entertainment,200.0,2024-06-03,true");

        writer.flush();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=report.csv");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(inputStream));
    }
}

