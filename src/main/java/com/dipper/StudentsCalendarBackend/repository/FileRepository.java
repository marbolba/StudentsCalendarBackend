package com.dipper.StudentsCalendarBackend.repository;

import com.dipper.StudentsCalendarBackend.dto.FileDto;
import com.dipper.StudentsCalendarBackend.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {

    @Query("select new com.dipper.StudentsCalendarBackend.dto.FileDto(a.fileId, a.classesId, a.fileFormat, a.fileSize) from FileEntity a where fileOwnerId=:#{#fileOwnerId} and classesId=:#{#classesId}")
    List<FileDto> findByFileOwnerIdAndClassesId(@Param("fileOwnerId") int fileOwnerId,@Param("classesId") int classesId);
}