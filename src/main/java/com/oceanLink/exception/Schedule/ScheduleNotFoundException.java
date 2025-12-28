package com.oceanLink.exception.Schedule;

import com.oceanLink.controller.ScheduleController;

public class ScheduleNotFoundException extends RuntimeException{
    public ScheduleNotFoundException(long id){
        super("Schedule with Id "+id);
    }
}
