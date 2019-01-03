package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.EventToEventDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.EventDto;
import com.dipper.StudentsCalendarBackend.dto.EventReceiveDto;
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
    private EventToEventDtoConverter eventToEventDtoConverter;

    public void addEvent(int eventOwnerId, EventReceiveDto eventReceiveDto){
        EventEntity eventEntity = new EventEntity();
        eventEntity.setEventOwner(new UserEntity(eventOwnerId));
        eventEntity.setDescription(eventReceiveDto.getDescription());
        eventEntity.setName(eventReceiveDto.getName());
        eventEntity.setStartTime(eventReceiveDto.getStartTime());
        eventEntity.setEndTime(eventReceiveDto.getEndTime());
        eventEntity.setEventDate(eventReceiveDto.getEventDate());

        eventRepository.save(eventEntity);
    }

    public List<EventDto> getUsersEvents(int userId){
        return eventToEventDtoConverter.convertList(eventRepository.findByEventOwner(new UserEntity(userId)));
    }
}
