package com.dipper.StudentsCalendarBackend.controller;


import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import com.dipper.StudentsCalendarBackend.service.ClassesService;
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

  private CourseService courseService;
  private ClassesService classesService;

  @Autowired
  public CourseController(CourseService courseService,
      ClassesService classesService) {
    this.courseService = courseService;
    this.classesService = classesService;
  }

  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
  ResponseEntity<?> addNewCourse(@RequestBody CourseEntity newCourse) {
    CourseEntity addedCourse = courseService.addCourse(newCourse);
    classesService.createClassesForCourse(addedCourse);
    return new ResponseEntity<String>(HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  ResponseEntity<?> getCourses(@RequestParam int userId){
    return new ResponseEntity<>(courseService.getCoursesDto(userId),HttpStatus.OK);
  }
}
