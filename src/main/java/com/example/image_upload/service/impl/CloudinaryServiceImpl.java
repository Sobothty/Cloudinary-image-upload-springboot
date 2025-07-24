package com.example.image_upload.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.image_upload.dto.ImageResponse;
import com.example.image_upload.service.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CloudinaryServiceImpl implements CloudinaryService {


    private final Cloudinary cloudinary;

    @Override
    public ImageResponse uploadFile(MultipartFile multipartFile) throws IOException{
        Map uploadResult = cloudinary.uploader().upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
        String secureUrl = uploadResult.get("secure_url").toString();
        String publicId = uploadResult.get("public_id").toString();
        return new ImageResponse(
                secureUrl, publicId
        );
    }
}
