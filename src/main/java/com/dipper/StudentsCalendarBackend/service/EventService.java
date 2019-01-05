package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.EventToEventViewConverter;
import com.dipper.StudentsCalendarBackend.view.EventView;
import com.dipper.StudentsCalendarBackend.view.EventReceiveView;
import com.dipper.StudentsCalendarBackend.entity.EventEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventToEventViewConverter eventToEventViewConverter;

    public void addEvent(int eventOwnerId, EventReceiveView eventReceiveView){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventOwner(new UserEntity(eventOwnerId));
        eventEntity.setDescription(eventReceiveView.getDescription());
        eventEntity.setName(eventReceiveView.getName());
        eventEntity.setStartTime(eventReceiveView.getStartTime());
        eventEntity.setEndTime(eventReceiveView.getEndTime());
        eventEntity.setEventDate(eventReceiveView.getEventDate());

        eventRepository.save(eventEntity);
    }

    public List<EventView> getUsersEvents(int userId){
        return eventToEventViewConverter.convertList(eventRepository.findByEventOwner(new UserEntity(userId)));
    }
}
