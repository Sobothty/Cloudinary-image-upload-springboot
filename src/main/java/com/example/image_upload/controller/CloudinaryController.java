package com.example.image_upload.controller;


import com.example.image_upload.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/image")
public class CloudinaryController {

    private final CloudinaryService cloudinaryService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadToCloudinary(@RequestParam("file") MultipartFile file){
        try{
            String uploadUrl = cloudinaryService.uploadFile(file);
            return new ResponseEntity<>(
                    Map.of(
                            "image_url", uploadUrl,
                            "timestamp", LocalDate.now()
                    ),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return ResponseEntity.status(500).body("Upload failed: " + e.getMessage());
        }

    }
}
