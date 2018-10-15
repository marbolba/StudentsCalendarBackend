package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import com.dipper.StudentsCalendarBackend.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    FileEntity saveFile(FileEntity fileEntity){
        return fileRepository.save(fileEntity);
    }
}
