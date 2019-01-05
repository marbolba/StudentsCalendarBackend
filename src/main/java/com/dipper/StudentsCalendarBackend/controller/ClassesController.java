package com.dipper.StudentsCalendarBackend.controller;

import com.dipper.StudentsCalendarBackend.converter.ClassesToClassesViewConverter;
import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import com.dipper.StudentsCalendarBackend.service.ClassesService;
import com.dipper.StudentsCalendarBackend.service.CourseService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/classes")
public class ClassesController {

    private CourseService courseService;
    private ClassesService classesService;
    private ClassesToClassesViewConverter classesToClassesViewConverter;

    @Autowired
    public ClassesController(CourseService courseService,
                             ClassesService classesService,
                             ClassesToClassesViewConverter classesToClassesViewConverter) {
        this.courseService = courseService;
        this.classesService = classesService;
        this.classesToClassesViewConverter = classesToClassesViewConverter;
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
            System.out.println("Could not parse dates");
        }

        List<ClassesEntity> usersClasses = new ArrayList<>();
        for (CourseEntity courseEntity : usersCourses) {
            for (ClassesEntity classesEntity : courseEntity.getClasses()) {
                if (classesEntity.getClassesFullStartDate().after(dateFrom) && classesEntity.getClassesFullEndDate().before(dateTo)) {
                    usersClasses.add(classesEntity);
                }
            }
        }
        return new ResponseEntity<>(classesToClassesViewConverter.convertList(usersClasses), HttpStatus.OK);
    }
}
