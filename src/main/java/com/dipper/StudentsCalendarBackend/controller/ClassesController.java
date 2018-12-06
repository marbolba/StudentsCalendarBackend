package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.converter.ClassesToClassesDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.CoursesDto;
import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import com.dipper.StudentsCalendarBackend.service.ClassesService;
import com.dipper.StudentsCalendarBackend.service.CourseService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@CrossOrigin
@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    private CourseService courseService;
    private ClassesService classesService;
    private ClassesToClassesDtoConverter classesToClassesDtoConverter;

    @Autowired
    public ClassesController(CourseService courseService,
                             ClassesService classesService,
                             ClassesToClassesDtoConverter classesToClassesDtoConverter) {
        this.courseService = courseService;
        this.classesService = classesService;
        this.classesToClassesDtoConverter = classesToClassesDtoConverter;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    ResponseEntity<?> getClasses(@RequestParam int userId, @RequestParam int year, @RequestParam int month, @RequestParam int lastDayOfMonth) {
        List<CourseEntity> usersCourses = courseService.getCourses(userId);
        Date dateFrom = null;
        Date dateTo = null;
        try {
            dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");
            dateTo = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(year + "-" + month + "-" + lastDayOfMonth + " 23:59");

        } catch (ParseException e) {
        }

        List<ClassesEntity> usersClasses = new ArrayList<>();
        for (CourseEntity courseEntity : usersCourses) {
            for (ClassesEntity classesEntity : courseEntity.getClasses()) {
                if (classesEntity.getClassesFullStartDate().after(dateFrom) && classesEntity.getClassesFullEndDate().before(dateTo)) {
                    usersClasses.add(classesEntity);
                }
            }
        }
        return new ResponseEntity<>(classesToClassesDtoConverter.convertList(usersClasses), HttpStatus.OK);
    }
}
