package com.dipper.StudentsCalendarBackend.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId", updatable = false, nullable = false)
    private int fileId;

    private int fileOwnerId;
    private int classesId;

    private byte[] imageDataBytes;
    private String fileFormat;
    private String fileSize;

    public byte[] getImageDataBytes() {
        return imageDataBytes;
    }

    public void setImageDataBytes(byte[] imageDataBytes) {
        this.imageDataBytes = imageDataBytes;
    }

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getFileOwnerId() {
        return fileOwnerId;
    }

    public void setFileOwnerId(int fileOwnerId) {
        this.fileOwnerId = fileOwnerId;
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

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "fileId=" + fileId +
                ", fileOwnerId=" + fileOwnerId +
                ", classesId=" + classesId +
                ", fileFormat='" + fileFormat + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }
}
