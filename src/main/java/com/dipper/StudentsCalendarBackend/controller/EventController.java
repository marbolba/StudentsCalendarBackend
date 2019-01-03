package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.dto.EventDto;
import com.dipper.StudentsCalendarBackend.dto.EventReceiveDto;
import com.dipper.StudentsCalendarBackend.service.EventService;
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
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<?> addCustomEvent(@RequestParam int eventOwnerId,@RequestBody EventReceiveDto eventReceiveDto){
        eventService.addEvent(eventOwnerId, eventReceiveDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<?> getCustomEvents(@RequestParam int userId, @RequestParam int year, @RequestParam int month, @RequestParam int lastDayOfMonth) {
        List<EventDto> usersEvents = eventService.getUsersEvents(userId);

        Date dateFrom = null;
        Date dateTo = null;
        try {
            dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");
            dateTo = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(year + "-" + month + "-" + lastDayOfMonth + " 23:59");

        } catch (ParseException e) {
            System.out.println("Could not parse dates");
        }

        List<EventDto> thisMonthsUsersEvents = new ArrayList<>();
        for (EventDto eventDto : usersEvents) {
            if (eventDto.getEventDate().after(dateFrom) && eventDto.getEventDate().before(dateTo)) {
                thisMonthsUsersEvents.add(eventDto);
            }
        }
        return new ResponseEntity<>(thisMonthsUsersEvents,HttpStatus.OK);
    }
}
