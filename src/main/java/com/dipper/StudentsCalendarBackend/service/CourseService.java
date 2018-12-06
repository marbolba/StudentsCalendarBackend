package com.dipper.StudentsCalendarBackend.service;

import com.dipper.StudentsCalendarBackend.converter.CoursesToCoursesDtoConverter;
import com.dipper.StudentsCalendarBackend.dto.CoursesDto;
import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import com.dipper.StudentsCalendarBackend.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private CoursesToCoursesDtoConverter coursesToCoursesDtoConverter;

  public CourseEntity addCourse(CourseEntity courseEntity){
    return courseRepository.save(courseEntity);
  }

  public List<CoursesDto> getCoursesDto(int userId){
    List<CourseEntity> coursesList = courseRepository.findByCourseOwner(new UserEntity(userId));
    return coursesToCoursesDtoConverter.convertList(coursesList);
  }

  public List<CourseEntity> getCourses(int userId){
    return courseRepository.findByCourseOwner(new UserEntity(userId));
  }
}
