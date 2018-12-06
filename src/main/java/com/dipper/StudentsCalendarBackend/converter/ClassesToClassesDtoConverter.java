package com.dipper.StudentsCalendarBackend.converter;

import com.dipper.StudentsCalendarBackend.dto.ClassesDto;
import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassesToClassesDtoConverter {
    public ClassesDto convert(ClassesEntity classesEntity){
        return new ClassesDto(classesEntity.getClassesId(),classesEntity.getParentCourseId().getCourseId(),classesEntity.getClassesName(),classesEntity.getClassesType(),classesEntity.getClassesFullStartDate(),classesEntity.getClassesFullEndDate());
    }
    public List<ClassesDto> convertList(List<ClassesEntity> classesEntityList){
        List<ClassesDto> classesDtoList = new ArrayList<>();
        for(ClassesEntity classesEntity: classesEntityList){
            classesDtoList.add(convert(classesEntity));
        }
        return classesDtoList;
    }
}
