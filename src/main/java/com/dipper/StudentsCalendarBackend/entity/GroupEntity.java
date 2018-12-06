package com.dipper.StudentsCalendarBackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Groups")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", updatable = false, nullable = false)
    private int groupId;

    @Column(name = "group_name",nullable = false)
    private String groupName;

    @Column(name = "group_description")
    private String groupDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="groupOwner", nullable=false)
    private UserEntity groupOwner;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="groups_to_users",
            joinColumns = {@JoinColumn(name=("groupId"))},
            inverseJoinColumns = {@JoinColumn(name=("user_id"))})
    private List<UserEntity> users = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="files_to_groups",
            joinColumns = {@JoinColumn(name=("groupId"))},
            inverseJoinColumns = {@JoinColumn(name=("fileId"))})
    private List<FileEntity> files = new ArrayList<>();

    public GroupEntity() {
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public UserEntity getGroupOwner() {
        return groupOwner;
    }

    public void setGroupOwner(UserEntity groupOwner) {
        this.groupOwner = groupOwner;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users.add(users);
    }

    public List<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(FileEntity files) {
        this.files.add(files);
    }

}
