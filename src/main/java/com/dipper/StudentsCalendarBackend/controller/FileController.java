package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

@RestController
@CrossOrigin
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveFile(@RequestParam(value = "file") MultipartFile file,@RequestParam int fileOwnerId,@RequestParam int classesId){
        fileService.saveFile(file,fileOwnerId,classesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {"fileOwnerId","classesId"})
    public ResponseEntity<?> getClassesFiles(@RequestParam int fileOwnerId,@RequestParam int classesId){
        return new ResponseEntity<>(fileService.getClassesFiles(fileOwnerId,classesId),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, params = {"coursesId"})
    public ResponseEntity<?> getCoursesFiles(@RequestParam int coursesId){
        return new ResponseEntity<>(fileService.getCoursesFiles(coursesId),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE, params = {"fileId"})
    public ResponseEntity<?> getFileById(@RequestParam int fileId){
        return new ResponseEntity<>(fileService.getFile(fileId),HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFile(@RequestParam int fileId){
        fileService.deleteFile(fileId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/download", method = RequestMethod.GET, params = {"fileId"})
    public ResponseEntity<?> downloadFile(@RequestParam int fileId, HttpServletResponse response){
        try {
            File file = fileService.getFileToDownload(fileId);
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment;filename=" + file.getName())
                    .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                    .body(resource);
        }catch (Exception e ){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
