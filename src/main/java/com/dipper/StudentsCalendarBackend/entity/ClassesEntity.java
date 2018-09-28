package com.dipper.StudentsCalendarBackend.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Classes")
public class ClassesEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "classes_id", updatable = false, nullable = false)
  int classesId;

  @Column(name = "course_id", updatable = false)
  int parentCourseId;
  String classesName;
  String classesType;

  @Temporal(TemporalType.TIMESTAMP)
  Date classesFullStartDate;
  @Temporal(TemporalType.TIMESTAMP)
  Date classesFullEndDate;

  public ClassesEntity(int classesParentCourse_id, String classesName, String classesType,
      Date classesFullStartDate, Date classesFullEndDate) {
    this.parentCourseId = classesParentCourse_id;
    this.classesName = classesName;
    this.classesType = classesType;
    this.classesFullStartDate = classesFullStartDate;
    this.classesFullEndDate = classesFullEndDate;
  }

  public ClassesEntity() {}

  public int getClasses_id() {
    return classesId;
  }

  public void setClasses_Id(int classesId) {
    this.classesId = classesId;
  }

  public int getParentCourse_id() {
    return parentCourseId;
  }

  public void setParentCourse_id(int parentCourseId) {
    this.parentCourseId = parentCourseId;
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

  @Override
  public String toString() {
    return "ClassesEntity{" +
        "classes_id=" + classesId +
        ", parentCourse_id=" + parentCourseId +
        ", classesName='" + classesName + '\'' +
        ", classesType='" + classesType + '\'' +
        ", classesFullStartDate=" + classesFullStartDate +
        ", classesFullEndDate=" + classesFullEndDate +
        '}';
  }
}
