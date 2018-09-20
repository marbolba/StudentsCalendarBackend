package com.dipper.StudentsCalendarBackend.controller;


import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import com.dipper.StudentsCalendarBackend.service.CourseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/courses")
public class CourseController {

  @Autowired
  private CourseService courseService;

  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
  ResponseEntity<?> addNewCourse(@RequestBody CourseEntity newCourse) {
    courseService.addCourse(newCourse);
    return new ResponseEntity<String>(HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  ResponseEntity<?> getCourses(){
    return new ResponseEntity<List<CourseEntity>>(courseService.getCourses(),HttpStatus.OK);
  }
}
