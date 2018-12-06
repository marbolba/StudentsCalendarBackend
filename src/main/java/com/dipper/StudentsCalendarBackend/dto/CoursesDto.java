package com.dipper.StudentsCalendarBackend.dto;

import java.util.List;

public class CoursesDto {

    private int courseId;

    private int courseOwner;

    private String courseName;
    private String courseType;
    private int courseDay;
    private String startTime;
    private String endTime;
    private String startDate;
    private String endDate;
    private List<Integer> classes;

    public CoursesDto(int courseId, int courseOwner, String courseName, String courseType, int courseDay,
                      String startTime, String endTime, String startDate, String endDate, List<Integer> classes) {
        this.courseId = courseId;
        this.courseOwner = courseOwner;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseDay = courseDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.classes = classes;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCourseOwner() {
        return courseOwner;
    }

    public void setCourseOwner(int courseOwner) {
        this.courseOwner = courseOwner;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getCourseDay() {
        return courseDay;
    }

    public void setCourseDay(int courseDay) {
        this.courseDay = courseDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Integer> getClasses() {
        return classes;
    }

    public void setClasses(List<Integer> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "CoursesDto{" +
                "courseId=" + courseId +
                ", courseOwner=" + courseOwner +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseDay=" + courseDay +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", classes=" + classes +
                '}';
    }
}
