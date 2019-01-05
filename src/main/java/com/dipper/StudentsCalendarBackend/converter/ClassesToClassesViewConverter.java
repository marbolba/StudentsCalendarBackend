package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.view.ClassesView;
import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesToClassesViewConverter {
    public ClassesView convert(ClassesEntity classesEntity){
        return new ClassesView(classesEntity.getClassesId(),classesEntity.getParentCourseId().getCourseId(),classesEntity.getClassesName(),classesEntity.getClassesType(),classesEntity.getClassesFullStartDate(),classesEntity.getClassesFullEndDate());
    }
    public List<ClassesView> convertList(List<ClassesEntity> classesEntityList){
        List<ClassesView> classesViewList = new ArrayList<>();
        for(ClassesEntity classesEntity: classesEntityList){
            classesViewList.add(convert(classesEntity));
        }
        return classesViewList;
    }
}
