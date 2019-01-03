package com.dipper.StudentsCalendarBackend.dto;

import java.util.Date;

public class EventDto {

    private int customEventId;
    private int eventOwner;

    private Date eventDate;
    private String name;
    private String description;
    private String startTime;
    private String endTime;

    public EventDto(int customEventId, int eventOwner, Date eventDate, String name, String description, String startTime, String endTime) {
        this.customEventId = customEventId;
        this.eventOwner = eventOwner;
        this.eventDate = eventDate;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getCustomEventId() {
        return customEventId;
    }

    public void setCustomEventId(int customEventId) {
        this.customEventId = customEventId;
    }

    public int getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(int eventOwner) {
        this.eventOwner = eventOwner;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}