package com.dipper.StudentsCalendarBackend.view;
import java.util.Arrays;
import java.util.Date;

public class FileDataView {

    private int fileId;
    private int fileOwner;
    private int parentClassesId;

    private Date editDate;
    private byte[] fileBytes;
    private String fileFormat;
    private long fileSize;
    private String fileName;

    public FileDataView(int fileId, int fileOwner, Date editDate, int parentClassesId, byte[] fileBytes, String fileFormat, long fileSize, String fileName) {
        this.fileId = fileId;
        this.fileOwner = fileOwner;
        this.editDate = editDate;
        this.parentClassesId = parentClassesId;
        this.fileBytes = fileBytes;
        this.fileFormat = fileFormat;
        this.fileSize = fileSize;
        this.fileName = fileName;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getFileOwner() {
        return fileOwner;
    }

    public void setFileOwner(int fileOwner) {
        this.fileOwner = fileOwner;
    }

    public int getParentClassesId() {
        return parentClassesId;
    }

    public void setParentClassesId(int parentClassesId) {
        this.parentClassesId = parentClassesId;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
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

    @Override
    public String toString() {
        return "FileDataView{" +
                "fileId=" + fileId +
                ", fileOwner=" + fileOwner +
                ", parentClassesId=" + parentClassesId +
                ", fileBytes=" + Arrays.toString(fileBytes) +
                ", fileName='" + fileName + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", fileSize=" + fileSize +
                '}';
    }
}
