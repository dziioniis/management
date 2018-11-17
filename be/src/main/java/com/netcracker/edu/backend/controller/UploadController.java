package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.repository.AttachementRepository;
import com.netcracker.edu.backend.service.AttachementService;
import com.netcracker.edu.backend.service.impl.AttachementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("/api/upload/{task}")
public class UploadController {
    @Autowired
    AttachementService attachementService;

    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam("file") MultipartFile file,@PathVariable("task") long task) throws IOException {
       System.out.println("file:"+file.getOriginalFilename()+"-task"+task);
      return attachementService.saveAttachement(file,task);
    }

}
