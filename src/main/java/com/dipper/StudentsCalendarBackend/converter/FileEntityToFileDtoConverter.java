package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.FileDto;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import org.springframework.stereotype.Component;

@Component
public class FileEntityToFileDtoConverter {
    public FileDto convert(FileEntity fileEntity){
        return new FileDto(fileEntity.getFileId(),fileEntity.getClassesId(),fileEntity.getFileFormat(),fileEntity.getFileSize(),fileEntity.getFileName());
    }
}
