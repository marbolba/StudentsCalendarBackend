package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.CustomEventToCustomEventDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.CustomEventDto;
import com.dipper.StudentsCalendarBackend.dto.CustomEventReceiveDto;
import com.dipper.StudentsCalendarBackend.entity.CustomEventEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.CustomEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomEventService {
    @Autowired
    private CustomEventRepository customEventRepository;
    @Autowired
    private CustomEventToCustomEventDtoConverter customEventToCustomEventDtoConverter;

    public void addEvent(int eventOwnerId, CustomEventReceiveDto customEventReceiveDto){
        CustomEventEntity customEventEntity = new CustomEventEntity();
        customEventEntity.setEventOwner(new UserEntity(eventOwnerId));
        customEventEntity.setDescription(customEventReceiveDto.getDescription());
        customEventEntity.setName(customEventReceiveDto.getName());
        customEventEntity.setStartTime(customEventReceiveDto.getStartTime());
        customEventEntity.setEndTime(customEventReceiveDto.getEndTime());
        customEventEntity.setEventDate(customEventReceiveDto.getEventDate());

        customEventRepository.save(customEventEntity);
    }

    public List<CustomEventDto> getUsersEvents(int userId){
        return customEventToCustomEventDtoConverter.convertList(customEventRepository.findByEventOwner(new UserEntity(userId)));
    }
}
