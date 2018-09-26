package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.entity.ClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<ClassesEntity, String> {

}