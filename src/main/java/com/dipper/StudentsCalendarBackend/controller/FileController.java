package com.dipper.StudentsCalendarBackend.controller;

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
    private UserService fileService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveFile(@RequestParam(value = "file") MultipartFile file){
        System.out.println(file);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
