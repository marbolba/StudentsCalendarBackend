package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.entity.CustomEventEntity;
import com.dipper.StudentsCalendarBackend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomEventRepository extends JpaRepository<CustomEventEntity, Integer> {
    public List<CustomEventEntity> findByEventOwner(UserEntity eventOwner);
}