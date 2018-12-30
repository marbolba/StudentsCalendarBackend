package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.CustomEventDto;
import com.dipper.StudentsCalendarBackend.entity.CustomEventEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomEventToCustomEventDtoConverter {
    public CustomEventDto convert(CustomEventEntity customEventEntity){
        return new CustomEventDto(customEventEntity.getCustomEventId(),customEventEntity.getEventOwner().getUserId(),
                customEventEntity.getEventDate(),customEventEntity.getName(),customEventEntity.getDescription(),
                customEventEntity.getStartTime(),customEventEntity.getEndTime());
    }
    public List<CustomEventDto> convertList(List<CustomEventEntity> customEventEntities){
        List<CustomEventDto> classesDtoList = new ArrayList<>();
        for(CustomEventEntity customEventEntity: customEventEntities){
            classesDtoList.add(convert(customEventEntity));
        }
        return classesDtoList;
    }
}
