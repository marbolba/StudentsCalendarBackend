package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.EventDto;
import com.dipper.StudentsCalendarBackend.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventToEventDtoConverter {
    public EventDto convert(EventEntity eventEntity){
        return new EventDto(eventEntity.getEventId(), eventEntity.getEventOwner().getUserId(),
                eventEntity.getEventDate(), eventEntity.getName(), eventEntity.getDescription(),
                eventEntity.getStartTime(), eventEntity.getEndTime());
    }
    public List<EventDto> convertList(List<EventEntity> customEventEntities){
        List<EventDto> classesDtoList = new ArrayList<>();
        for(EventEntity eventEntity : customEventEntities){
            classesDtoList.add(convert(eventEntity));
        }
        return classesDtoList;
    }
}
