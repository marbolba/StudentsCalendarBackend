package com.dipper.StudentsCalendarBackend.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private int user_id;

    @Column(name = "userName",nullable = false)
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<GroupEntity> users_groups;

    @OneToMany(/*fetch= FetchType.LAZY, cascade = CascadeType.ALL, */mappedBy="group_owner")
    private List<GroupEntity> groups_owner;

    public UserEntity() {
    }

    public UserEntity(int user_id) {
        this.user_id = user_id;
    }
    public boolean checkById(int userId) {return this.user_id==userId;}

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public List<GroupEntity> getUsers_groups() {
        return users_groups;
    }

    public void setUsers_groups(List<GroupEntity> users_groups) {
        this.users_groups = users_groups;
    }

    public List<GroupEntity> getGroups_owner() {
        return groups_owner;
    }

    public void setGroups_owner(List<GroupEntity> groups_owner) {
        this.groups_owner = groups_owner;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", users_groups=" + users_groups +
                ", groups_owner=" + groups_owner +
                '}';
    }
}
