package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.FileEntityToFileDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.FileDataDto;
import com.dipper.StudentsCalendarBackend.dto.FileDto;
import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private FileEntityToFileDtoConverter fileEntityToFileDtoConverter;
    @Autowired
    private GroupService groupService;

    public void saveFile(MultipartFile file, int fileOwnerId, int classesId){
        //prepare data
        byte[] fileBytes=null;
        try {
            fileBytes = file.getBytes();
        } catch (IOException e) {
            System.out.println("Error converting Multipart file to dataBytes");
        }

        System.out.println(fileOwnerId+","+classesId);

        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileOwner(new UserEntity(fileOwnerId));
        fileEntity.setParentClassesId(new ClassesEntity(classesId));
        fileEntity.setFileBytes(fileBytes);
        fileEntity.setFileFormat(file.getContentType());
        fileEntity.setFileSize(file.getSize());
        fileEntity.setFileName(file.getOriginalFilename());

        System.out.println(fileEntity.getFileOwner());

        fileRepository.save(fileEntity);
    }

    public List<FileDto> getClassesFiles(int fileOwnerId, int classesId){
        return fileEntityToFileDtoConverter.convertList(fileRepository.findByFileOwnerAndParentClassesId(new UserEntity(fileOwnerId),new ClassesEntity(classesId)));
    }
    public List<FileDto> getCoursesFiles(int coursesId){
        System.out.println("recieved " + coursesId);
        System.out.println(fileEntityToFileDtoConverter.convertList(fileRepository.findByParentClassesId(coursesId)));
        return fileEntityToFileDtoConverter.convertList(fileRepository.findByParentClassesId(coursesId));
    }
    public FileDataDto getFile(int fileId){
        return fileEntityToFileDtoConverter.convertToData(fileRepository.findById(fileId).get());
    }
    public void deleteFile(int fileId){
        FileEntity fileEntity = fileRepository.findById(fileId).get();
        for(GroupEntity groupEntity : fileEntity.getSharedToGroups()){
            groupService.deleteFile(groupEntity.getGroupId(),fileId);
        }
        fileRepository.deleteById(fileId);
    }
    public FileEntity getFileById(int fileId){
        return fileRepository.findById(fileId).get();
    }
    public File getFileToDownload(int fileId){
        try {
            FileEntity fileEntity = getFileById(fileId);
            File convFile = new File(fileEntity.getFileName());
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(fileEntity.getFileBytes());
            fos.close();
            return convFile;
        }catch (Exception e ){return null;}
    }
}
