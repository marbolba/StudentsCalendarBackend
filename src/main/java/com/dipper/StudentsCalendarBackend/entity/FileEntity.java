package com.dipper.StudentsCalendarBackend.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Files")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fileId", updatable = false, nullable = false)
    private int fileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fileOwner", nullable=false)
    private UserEntity fileOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parentClassesId", nullable=false)
    private ClassesEntity parentClassesId;

    //TODO dodac do ERD
    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate = new Date();

    private byte[] fileBytes;
    private String fileName;
    private String fileFormat;
    private long fileSize;

    @ManyToMany(mappedBy = "files")
    private List<GroupEntity> sharedToGroups;

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editTime) {
        this.editDate = editTime;
    }

    public UserEntity getFileOwner() {
        return fileOwner;
    }

    public void setFileOwner(UserEntity fileOwner) {
        this.fileOwner = fileOwner;
    }

    public ClassesEntity getParentClassesId() {
        return parentClassesId;
    }

    public void setParentClassesId(ClassesEntity parentClassesId) {
        this.parentClassesId = parentClassesId;
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public List<GroupEntity> getSharedToGroups() {
        return sharedToGroups;
    }

    public void setSharedToGroups(List<GroupEntity> sharedToGroups) {
        this.sharedToGroups = sharedToGroups;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "fileId=" + fileId +
                ", fileOwner=" + fileOwner +
                ", parentClassesId=" + parentClassesId +
                ", fileBytes=" + Arrays.toString(fileBytes) +
                ", fileName='" + fileName + '\'' +
                ", fileFormat='" + fileFormat + '\'' +
                ", fileSize=" + fileSize +
                ", sharedToGroups=" + sharedToGroups +
                '}';
    }
}
