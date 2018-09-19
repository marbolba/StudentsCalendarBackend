package com.dipper.StudentsCalendarBackend.controller;


import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class CourseController {

    @RequestMapping(value = "/courses",method = RequestMethod.POST, consumes = "application/json")
    ResponseEntity<?> addNewCourse(@RequestBody CourseEntity course){
        System.out.println(course);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
