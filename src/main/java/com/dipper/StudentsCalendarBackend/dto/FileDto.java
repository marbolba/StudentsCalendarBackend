package com.dipper.StudentsCalendarBackend.dto;

import javax.persistence.*;

@Entity
@Table(name = "Files")
public class FileDto {
    @Id
    @Column(name = "fileId", updatable = false, nullable = false)
    private int fileId;

    private int classesId;

    private String fileFormat;
    private long fileSize;
    private String fileName;

    public FileDto(int fileId, int classesId, String fileFormat, long fileSize, String fileName) {
        this.fileId = fileId;
        this.classesId = classesId;
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
        this.fileName = fileName;
    }

    public FileDto() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
