package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.service.FileService;
import com.dipper.StudentsCalendarBackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveFile(@RequestParam(value = "file") MultipartFile file,@RequestParam int fileOwnerId,@RequestParam int classesId){
        fileService.saveFile(file,fileOwnerId,classesId);
        System.out.println(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCoursesFiles(@RequestParam int fileOwnerId,@RequestParam int classesId){
        return new ResponseEntity<>(fileService.getCoursesFiles(fileOwnerId,classesId),HttpStatus.OK);
    }

}
