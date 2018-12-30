package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.dto.CustomEventDto;
import com.dipper.StudentsCalendarBackend.dto.CustomEventReceiveDto;
import com.dipper.StudentsCalendarBackend.entity.CustomEventEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.service.CustomEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        List<CustomEventDto> usersEvents = customEventService.getUsersEvents(userId);

        Date dateFrom = null;
        Date dateTo = null;
        try {
            dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");
            dateTo = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(year + "-" + month + "-" + lastDayOfMonth + " 23:59");

        } catch (ParseException e) {
            System.out.println("Could not parse dates");
        }

        List<CustomEventDto> thisMonthsUsersEvents = new ArrayList<>();
        for (CustomEventDto customEventDto : usersEvents) {
            if (customEventDto.getEventDate().after(dateFrom) && customEventDto.getEventDate().before(dateTo)) {
                thisMonthsUsersEvents.add(customEventDto);
            }
        }
        return new ResponseEntity<>(thisMonthsUsersEvents,HttpStatus.OK);
    }
}
