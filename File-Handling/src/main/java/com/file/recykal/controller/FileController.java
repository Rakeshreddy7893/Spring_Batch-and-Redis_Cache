package com.file.recykal.controller;

import com.file.recykal.dao.FileRepository;
import com.file.recykal.entity.File;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    HttpServletResponse response;

    @PostMapping("/saveFile")
    public String saveFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            String contentType = file.getContentType();
            byte[] fileContent = file.getBytes();
            logger.info("File Saved Successfully To Db");
            File newFile = new File(fileName, contentType, fileContent);
            fileRepository.save(newFile);
            return "File saved successfully";
        } catch (Exception e) {
            logger.info("Error in saving the to Db");
            return "File Not Saved";
        }
    }

    @GetMapping("/getAllFiles")
    public List<File> getAllFiles() throws Exception {
        return fileRepository.findAll();
    }

    @GetMapping("getFile")
    public String getFileById(@RequestParam("id") String id) throws IOException {

        try {
            File file = fileRepository.findById(id).get();
            byte[] content = file.getData();
            response.reset();
            response.setContentType(file.getType());
            response.setHeader("Content-Disposition", "attachment;        filename=" + file.getName());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(response.getOutputStream());
            bufferedOutputStream.write(content);
            bufferedOutputStream.close();
            return "File Retrieved Successfully";
        }
        catch (Exception e){
            return "could Not Retrieve the file";
        }
    }

}
