package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.entity.CourseEntity;
import java.util.List;

import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Integer> {
  List<CourseEntity> findByCourseOwner(UserEntity courseOwner);
}