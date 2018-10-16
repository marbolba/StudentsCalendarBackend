package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.dto.FileDto;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import com.dipper.StudentsCalendarBackend.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public FileEntity saveFile(MultipartFile file,int fileOwnerId,int classesId){
        //prepare data
        byte[] fileBytes=null;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            System.out.println("Error converting Multipart file to dataBytes");
        }

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileOwnerId(fileOwnerId);
        fileEntity.setClassesId(classesId);
        fileEntity.setFileBytes(fileBytes);
        fileEntity.setFileFormat(file.getContentType());
        fileEntity.setFileSize(file.getSize());

        return fileRepository.save(fileEntity);
    }

    public List<FileDto> getCoursesFiles(int fileOwnerId, int classesId){
        return fileRepository.findByFileOwnerIdAndClassesId(fileOwnerId,classesId);
    }
}
