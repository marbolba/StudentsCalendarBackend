package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.CoursesDto;
import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoursesToCoursesDtoConverter {
    public CoursesDto convert(CourseEntity courseEntity){
        List<Integer> classes = new ArrayList<>();
        for(ClassesEntity classesEntity: courseEntity.getClasses()){
            classes.add(classesEntity.getClassesId());
        }
        System.out.println(classes);
        return new CoursesDto(
                courseEntity.getCourseId(),
                courseEntity.getCourseOwner().getUserId(),
                courseEntity.getCourseName(),
                courseEntity.getCourseType(),
                courseEntity.getCourseDay(),
                courseEntity.getStartTime(),
                courseEntity.getEndTime(),
                courseEntity.getStartDate(),
                courseEntity.getEndDate(),
                classes);
    }
    public List<CoursesDto> convertList(List<CourseEntity> courseEntityList){
        List<CoursesDto> coursesDtos = new ArrayList<>();
        for(CourseEntity course: courseEntityList){
            coursesDtos.add(convert(course));
        }
        return coursesDtos;
    }
}
