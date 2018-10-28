package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.GroupDto;
import com.dipper.StudentsCalendarBackend.entity.GroupEntity;
import org.springframework.stereotype.Component;

@Component
public class GroupEntityToGroupDtoConverter {
    public GroupDto convert(GroupEntity groupEntity){
        return new GroupDto(groupEntity.getGroupId(),groupEntity.getGroupName(),groupEntity.getGroupDescription());
    }
}
