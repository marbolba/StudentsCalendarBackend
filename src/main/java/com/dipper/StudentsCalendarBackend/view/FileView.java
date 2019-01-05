package com.dipper.StudentsCalendarBackend.view;

import java.util.Date;

public class FileView {

    private int fileId;
    private int parentClassesId;
    private int fileOwner;
    private Date editDate;

    private String fileFormat;
    private long fileSize;
    private String fileName;

    public FileView(int fileId, int parentClassesId, int fileOwner, Date editDate, String fileFormat, long fileSize, String fileName) {
        this.fileId = fileId;
        this.parentClassesId = parentClassesId;
        this.fileOwner = fileOwner;
        this.editDate = editDate;
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
        this.fileName = fileName;
    }

    public FileView() {
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

    public int getFileOwner() {
        return fileOwner;
    }

    public void setFileOwner(int fileOwner) {
        this.fileOwner = fileOwner;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
