package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import com.dipper.StudentsCalendarBackend.repository.CourseRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public void addCourse(CourseEntity courseEntity){
    courseRepository.save(courseEntity);
  }
  public List<CourseEntity> getCourses(){
    return courseRepository.findAll();
  }
}
