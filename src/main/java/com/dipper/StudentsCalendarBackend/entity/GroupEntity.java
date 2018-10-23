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
    private int group_id;

    @Column(name = "group_name",nullable = false)
    private String group_name;

    @Column(name = "group_description")
    private String group_description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity group_owner;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name="groups_to_users",
            joinColumns = {@JoinColumn(name=("group_id"))},
            inverseJoinColumns = {@JoinColumn(name=("user_id"))})
    private List<UserEntity> users = new ArrayList<>();


    public GroupEntity() {
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getGroup_description() {
        return group_description;
    }

    public void setGroup_description(String group_description) {
        this.group_description = group_description;
    }

    public UserEntity getGroup_owner() {
        return group_owner;
    }

    public void setGroup_owner(UserEntity group_owner) {
        this.group_owner = group_owner;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(UserEntity users) {
        this.users.add(users);
    }
}
