package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.view.GroupView;
import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupEntityToGroupViewConverter {
    public GroupView convert(GroupEntity groupEntity){
        return new GroupView(groupEntity.getGroupId(),groupEntity.getGroupName(),groupEntity.getGroupDescription());
    }
    public List<GroupView> convertList(List<GroupEntity> groupEntityList) {
        List<GroupView> groupViews = new ArrayList<>();
        for (GroupEntity fileEntity : groupEntityList) {
            groupViews.add(convert(fileEntity));
        }
        return groupViews;
    }
}
