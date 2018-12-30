package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.dto.CustomEventReceiveDto;
import com.dipper.StudentsCalendarBackend.entity.CustomEventEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.service.CustomEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/events")
public class CustomEventController {
    @Autowired
    private CustomEventService customEventService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<?> addCustomEvent(@RequestParam int eventOwnerId,@RequestBody CustomEventReceiveDto customEventReceiveDto){
        customEventService.addEvent(eventOwnerId,customEventReceiveDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<?> getCustomEvents(@RequestParam int userId, @RequestParam int year, @RequestParam int month, @RequestParam int lastDayOfMonth) {
        return new ResponseEntity<>(customEventService.getUsersEvents(userId),HttpStatus.OK);
    }
}
