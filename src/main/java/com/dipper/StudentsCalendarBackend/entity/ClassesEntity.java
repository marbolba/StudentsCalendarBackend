package com.dipper.StudentsCalendarBackend.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Classes")
public class ClassesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  int classesId;
  int classesParentCourse;
  String classesName;
  String classesType;
  Date classesFullStartDate;
  Date classesFullEndDate;

  public ClassesEntity(int classesParentCourse, String classesName, String classesType,
      Date classesFullStartDate, Date classesFullEndDate) {
    this.classesParentCourse = classesParentCourse;
    this.classesName = classesName;
    this.classesType = classesType;
    this.classesFullStartDate = classesFullStartDate;
    this.classesFullEndDate = classesFullEndDate;
  }

  public int getClassesId() {
    return classesId;
  }

  public void setClassesId(int classesId) {
    this.classesId = classesId;
  }

  public int getClassesParentCourse() {
    return classesParentCourse;
  }

  public void setClassesParentCourse(int classesParentCourse) {
    this.classesParentCourse = classesParentCourse;
  }

  public String getClassesName() {
    return classesName;
  }

  public void setClassesName(String classesName) {
    this.classesName = classesName;
  }

  public String getClassesType() {
    return classesType;
  }

  public void setClassesType(String classesType) {
    this.classesType = classesType;
  }

  public Date getClassesFullStartDate() {
    return classesFullStartDate;
  }

  public void setClassesFullStartDate(Date classesFullStartDate) {
    this.classesFullStartDate = classesFullStartDate;
  }

  public Date getClassesFullEndDate() {
    return classesFullEndDate;
  }

  public void setClassesFullEndDate(Date classesFullEndDate) {
    this.classesFullEndDate = classesFullEndDate;
  }
}
