package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesEntity, String> {
  List<ClassesEntity> findAllByClassesFullStartDateBetweenAndParentCourseId(Date dateFrom,Date dateTo,int classesId);
}