package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.view.FileDataView;
import com.dipper.StudentsCalendarBackend.view.FileView;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileEntityToFileViewConverter {
    public FileView convert(FileEntity fileEntity) {
        return new FileView(fileEntity.getFileId(),
                fileEntity.getParentClassesId().getClassesId(),
                fileEntity.getFileOwner().getUserId(),
                fileEntity.getEditDate(),
                fileEntity.getFileFormat(),
                fileEntity.getFileSize(),
                fileEntity.getFileName());
    }

    public List<FileView> convertList(List<FileEntity> fileEntityList) {
        List<FileView> fileViews = new ArrayList<>();
        for (FileEntity fileEntity : fileEntityList) {
            fileViews.add(convert(fileEntity));
        }
        return fileViews;
    }

    public FileDataView convertToData(FileEntity fileEntity){
        return new FileDataView(fileEntity.getFileId(),
                fileEntity.getFileOwner().getUserId(),
                fileEntity.getEditDate(),
                fileEntity.getFileId(),
                fileEntity.getFileBytes(),
                fileEntity.getFileFormat(),
                fileEntity.getFileSize(),
                fileEntity.getFileName());
    }
}
