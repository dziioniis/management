package com.netcracker.edu.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
     String storeFile(MultipartFile file);
}
