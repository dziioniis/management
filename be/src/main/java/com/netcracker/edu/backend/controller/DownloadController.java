package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Attachement;
import com.netcracker.edu.backend.service.AttachementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@RequestMapping("api/download")
public class DownloadController {
    @Autowired
    AttachementService attachementService;
    @GetMapping("get/{task}")
    public Iterable<Attachement> getFilesByTask(@PathVariable long task){
        return attachementService.findByTask(task);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable long id) throws IOException {
        Optional<Attachement> fileOptional= Optional.ofNullable(attachementService.findById(id));
        Attachement file = fileOptional.get();
        if(fileOptional.isPresent()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new File(file.getUrl()).getName() + "\"")
                    .body(Files.readAllBytes(Paths.get(file.getUrl())));
        }
        return null;
    }
}
