package com.dipper.StudentsCalendarBackend.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CustomEvent")
public class CustomEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custom_event_id", updatable = false, nullable = false)
    private int customEventId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventOwner", nullable = false)
    private UserEntity eventOwner;

    @Temporal(TemporalType.DATE)
    private Date eventDate;
    private String name;
    private String description;
    private String startTime;
    private String endTime;

    public CustomEventEntity() {
    }

    public int getCustomEventId() {
        return customEventId;
    }

    public void setCustomEventId(int customEventId) {
        this.customEventId = customEventId;
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
        return "CustomEventEntity{" +
                "custom_event_id=" + customEventId +
                ", eventOwner=" + eventOwner +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", eventDate=" + eventDate +
                '}';
    }
}
