package com.dipper.StudentsCalendarBackend.view;

public class GroupView {

    private int groupId;

    private String groupName;

    private String groupDescription;

    public GroupView() {
    }

    public GroupView(int groupId, String groupName, String groupDescription) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
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
}
