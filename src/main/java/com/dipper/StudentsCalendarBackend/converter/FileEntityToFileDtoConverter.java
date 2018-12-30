package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.FileDataDto;
import com.dipper.StudentsCalendarBackend.dto.FileDto;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileEntityToFileDtoConverter {
    public FileDto convert(FileEntity fileEntity) {
        return new FileDto(fileEntity.getFileId(),
                fileEntity.getParentClassesId().getClassesId(),
                fileEntity.getFileOwner().getUserId(),
                fileEntity.getEditDate(),
                fileEntity.getFileFormat(),
                fileEntity.getFileSize(),
                fileEntity.getFileName());
    }

    public List<FileDto> convertList(List<FileEntity> fileEntityList) {
        List<FileDto> fileDtos = new ArrayList<>();
        for (FileEntity fileEntity : fileEntityList) {
            fileDtos.add(convert(fileEntity));
        }
        return fileDtos;
    }

    public FileDataDto convertToData(FileEntity fileEntity){
        return new FileDataDto(fileEntity.getFileId(),
                fileEntity.getFileOwner().getUserId(),
                fileEntity.getEditDate(),
                fileEntity.getFileId(),
                fileEntity.getFileBytes(),
                fileEntity.getFileFormat(),
                fileEntity.getFileSize(),
                fileEntity.getFileName());
    }
}
