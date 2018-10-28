package com.dipper.StudentsCalendarBackend.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId", updatable = false, nullable = false)
    private int fileId;

    private int fileOwnerId;
    private int classesId;

    private byte[] fileBytes;
    private String fileName;
    private String fileFormat;
    private long fileSize;

    @ManyToMany(mappedBy = "files")
    private List<GroupEntity> sharedToGroups;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
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
