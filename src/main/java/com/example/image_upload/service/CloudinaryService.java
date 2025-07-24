package com.example.image_upload.service;

import com.example.image_upload.dto.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface CloudinaryService {
    ImageResponse uploadFile(MultipartFile multipartFile) throws IOException;
}
