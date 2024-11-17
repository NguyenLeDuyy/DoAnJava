package uth.edu.backend.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uth.edu.backend.service.StorageService;

@Controller
@RequestMapping("/upload-test")
public class TestUploadFile {

    @Autowired
    private StorageService storageService;

    @GetMapping
    public String uploadDemo() {
        return "test-upload";
    }

    @PostMapping
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        storageService.store(file);
        return "test-upload";
    }
}