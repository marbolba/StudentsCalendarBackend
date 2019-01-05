package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.view.EventView;
import com.dipper.StudentsCalendarBackend.entity.EventEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventToEventViewConverter {
    public EventView convert(EventEntity eventEntity){
        return new EventView(eventEntity.getEventId(), eventEntity.getEventOwner().getUserId(),
                eventEntity.getEventDate(), eventEntity.getName(), eventEntity.getDescription(),
                eventEntity.getStartTime(), eventEntity.getEndTime());
    }
    public List<EventView> convertList(List<EventEntity> customEventEntities){
        List<EventView> classesDtoList = new ArrayList<>();
        for(EventEntity eventEntity : customEventEntities){
            classesDtoList.add(convert(eventEntity));
        }
        return classesDtoList;
    }
}
