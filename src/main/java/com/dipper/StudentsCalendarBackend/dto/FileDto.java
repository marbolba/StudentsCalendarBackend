package com.dipper.StudentsCalendarBackend.dto;

public class FileDto {

    private int fileId;
    private int parentClassesId;

    private String fileFormat;
    private long fileSize;
    private String fileName;

    public FileDto(int fileId, int parentClassesId, String fileFormat, long fileSize, String fileName) {
        this.fileId = fileId;
        this.parentClassesId = parentClassesId;
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

    public int getParentClassesId() {
        return parentClassesId;
    }

    public void setParentClassesId(int parentClassesId) {
        this.parentClassesId = parentClassesId;
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
