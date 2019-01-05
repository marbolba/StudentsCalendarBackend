package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.view.CoursesView;
import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CoursesToCoursesViewConverter {
    public CoursesView convert(CourseEntity courseEntity){
        List<Integer> classes = new ArrayList<>();
        for(ClassesEntity classesEntity: courseEntity.getClasses()){
            classes.add(classesEntity.getClassesId());
        }
        return new CoursesView(
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
    public List<CoursesView> convertList(List<CourseEntity> courseEntityList){
        List<CoursesView> coursesViews = new ArrayList<>();
        for(CourseEntity course: courseEntityList){
            coursesViews.add(convert(course));
        }
        return coursesViews;
    }
}
