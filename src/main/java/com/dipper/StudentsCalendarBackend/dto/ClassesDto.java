package com.dipper.StudentsCalendarBackend.dto;

import java.util.Date;

public class ClassesDto {

    private int classesId;
    private int parentCourseId;
    private String classesName;
    private String classesType;
    private Date classesFullStartDate;
    private Date classesFullEndDate;

    public ClassesDto(int classesId, int parentCourseId, String classesName, String classesType, Date classesFullStartDate, Date classesFullEndDate) {
        this.classesId = classesId;
        this.parentCourseId = parentCourseId;
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

    public int getParentCourseId() {
        return parentCourseId;
    }

    public void setParentCourseId(int parentCourseId) {
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
        return "ClassesDto{" +
                "classesId=" + classesId +
                ", parentCourseId=" + parentCourseId +
                ", classesName='" + classesName + '\'' +
                ", classesType='" + classesType + '\'' +
                ", classesFullStartDate=" + classesFullStartDate +
                ", classesFullEndDate=" + classesFullEndDate +
                '}';
    }
}
