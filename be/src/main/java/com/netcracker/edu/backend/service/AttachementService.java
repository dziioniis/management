package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Attachement;
import org.springframework.web.multipart.MultipartFile;

public interface AttachementService {
    String saveAttachement(MultipartFile file,long task);
   Iterable<Attachement>findByTask(long task);
    Attachement findById(long id);
}
