package com.dipper.StudentsCalendarBackend.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/classes")
public class ClassesController {

  private CourseService courseService;
  private ClassesService classesService;

  @Autowired
  public ClassesController(CourseService courseService,
      ClassesService classesService) {
    this.courseService = courseService;
    this.classesService = classesService;
  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  ResponseEntity<?> getClasses(@RequestParam int userId,@RequestParam int year,@RequestParam int month){
    List<CourseEntity> usersCourses = courseService.getCourses(userId);
    Date dateFrom = null;
    Date dateTo = null;
    try {
      dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-01");
      dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-30");

    }catch(ParseException e){}
    for(CourseEntity course: usersCourses){
      System.out.println("from:"+dateFrom+"\nto:"+dateTo);
      List<ClassesEntity> usersClasses = classesService.getCourseClasses(course.getCourse_id(),dateFrom,dateTo);
      System.out.println(usersClasses);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
