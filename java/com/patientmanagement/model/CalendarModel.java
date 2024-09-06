package com.patientmanagement.model;


import java.awt.Color;
import java.time.LocalDateTime;
import java.util.List;


public class CalendarModel {
        private List<CalendarEvent> events;
    
        public void addEvent(CalendarEvent event) {
            events.add(event);
        }
    
        public void removeEvent(CalendarEvent event) {
            events.remove(event);
        }
    
        public List<CalendarEvent> getEvents() {
            return events;
    }

    public class CalendarEvent {
        private LocalDateTime start;
        private LocalDateTime end;
        private String description;
        private Color color;
    
        // Getters, setters, and other event-related business logic
    }
    
}