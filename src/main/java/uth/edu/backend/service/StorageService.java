package uth.edu.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StorageService {
    void store(MultipartFile file);

    void init();
//
//    void deleteAll();
//
//    void delete(String filename);
}
