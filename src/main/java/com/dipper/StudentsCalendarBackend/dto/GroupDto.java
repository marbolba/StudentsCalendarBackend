package com.dipper.StudentsCalendarBackend.dto;

import com.dipper.StudentsCalendarBackend.entity.UserEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDto {

    private int group_id;

    private String groupName;

    private String group_description;

    public GroupDto() {
    }

    public GroupDto(int group_id, String groupName, String group_description) {
        this.group_id = group_id;
        this.groupName = groupName;
        this.group_description = group_description;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroup_description() {
        return group_description;
    }

    public void setGroup_description(String group_description) {
        this.group_description = group_description;
    }
}
