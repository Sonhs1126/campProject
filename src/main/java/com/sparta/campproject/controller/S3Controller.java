package com.sparta.campproject.controller;

import com.sparta.campproject.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class S3Controller {
    private final S3Uploader s3Uploader;

    @PostMapping("/images")
    @ResponseBody
    public String upload(@RequestParam("images") MultipartFile multipartFile) throws IOException {
        s3Uploader.upload(multipartFile,"static");
        return "업로드 완료";
    }
}
