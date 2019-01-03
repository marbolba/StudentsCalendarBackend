package com.dipper.StudentsCalendarBackend.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Event")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", updatable = false, nullable = false)
    private int eventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventOwner", nullable = false)
    private UserEntity eventOwner;

    @Temporal(TemporalType.DATE)
    private Date eventDate;
    private String name;
    private String description;
    private String startTime;
    private String endTime;

    public EventEntity() {
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public UserEntity getEventOwner() {
        return eventOwner;
    }

    public void setEventOwner(UserEntity eventOwner) {
        this.eventOwner = eventOwner;
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

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "event_id=" + eventId +
                ", eventOwner=" + eventOwner +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", eventDate=" + eventDate +
                '}';
    }
}
