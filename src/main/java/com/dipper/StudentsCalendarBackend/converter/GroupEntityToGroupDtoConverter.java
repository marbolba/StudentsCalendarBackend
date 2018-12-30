package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.GroupDto;
import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupEntityToGroupDtoConverter {
    public GroupDto convert(GroupEntity groupEntity){
        return new GroupDto(groupEntity.getGroupId(),groupEntity.getGroupName(),groupEntity.getGroupDescription());
    }
    public List<GroupDto> convertList(List<GroupEntity> groupEntityList) {
        List<GroupDto> groupDtos = new ArrayList<>();
        for (GroupEntity fileEntity : groupEntityList) {
            groupDtos.add(convert(fileEntity));
        }
        return groupDtos;
    }
}
