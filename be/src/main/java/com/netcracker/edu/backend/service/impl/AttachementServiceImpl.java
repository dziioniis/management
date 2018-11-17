package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Attachement;
import com.netcracker.edu.backend.repository.AttachementRepository;
import com.netcracker.edu.backend.service.AttachementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class AttachementServiceImpl implements AttachementService {
    @Autowired
    AttachementRepository attachementRepository;
    @Override
    public String saveAttachement(MultipartFile file,long task) {
        String fileName= file.getOriginalFilename();
        String name="C:"+File.separator+"newproject"+File.separator+"management"+File.separator+"be"+File.separator+"attachements"+File.separator;
        String path= name+fileName;
        System.out.println("in saveAttachement");
        try {
            saveFile(file.getInputStream(),path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Attachement attachement=new Attachement(fileName,path,task);
        attachementRepository.save(attachement);
        return path;
    }

    @Override
    public Iterable<Attachement> findByTask(long task) {
        return attachementRepository.findByTask(task);
    }

    @Override
    public Attachement findById(long id) {
        Attachement attachement= attachementRepository.findById(id);
        File file=new File(attachement.getUrl());
        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return attachement;
    }

    private void saveFile(InputStream inputStream, String path) throws IOException {
        try {
            OutputStream outputStream=new FileOutputStream(new File(path));
            int read=0;
            byte[]bytes=new byte[1024];
            while ((read=inputStream.read(bytes))!=-1) {
                outputStream.write(bytes,0,read);}
            outputStream.flush();;
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
