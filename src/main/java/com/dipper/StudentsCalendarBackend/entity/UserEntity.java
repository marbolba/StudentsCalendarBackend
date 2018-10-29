package com.dipper.StudentsCalendarBackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private int userId;

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    //minor relation
    @ManyToMany(mappedBy = "users")
    private List<GroupEntity> usersGroups;

    //minor relation
    @OneToMany(mappedBy="groupOwner")
    private List<GroupEntity> groupsOwner;

    public UserEntity() {
    }

    public UserEntity(int userId) {
        this.userId = userId;
    }

    public boolean checkById(int userId) {return this.userId==userId;}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GroupEntity> getUsersGroups() {
        return usersGroups;
    }

    public void setUsersGroups(List<GroupEntity> usersGroups) {
        this.usersGroups = usersGroups;
    }

    public List<GroupEntity> getGroupsOwner() {
        return groupsOwner;
    }

    public void setGroupsOwner(List<GroupEntity> groupsOwner) {
        this.groupsOwner = groupsOwner;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", usersGroups=" + usersGroups +
                ", groupsOwner=" + groupsOwner +
                '}';
    }
}
