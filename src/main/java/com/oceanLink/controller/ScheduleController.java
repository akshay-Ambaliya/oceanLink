package com.oceanLink.controller;

import com.oceanLink.dto.schedule.ScheduleRequestDTO;
import com.oceanLink.exception.Schedule.ScheduleNotFoundException;
import com.oceanLink.model.Schedules;
import com.oceanLink.service.schedules.ScheduleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleSevice service;

    @PostMapping
    public ResponseEntity<Schedules> addSchedule(@RequestBody ScheduleRequestDTO scheduleDto){
        return ResponseEntity.ok(service.createSchedule(scheduleDto));
    }

    @GetMapping
    public ResponseEntity<List<Schedules>> getAllSchedules(){
        List<Schedules> schedules = service.getAllSchedules();
        if(schedules.isEmpty()){
            return ResponseEntity.noContent().build();
        }else
            return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedules> getSchedulesById(@PathVariable Long id){
        return ResponseEntity.ok(service.getScheduleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteScheduleById(@PathVariable Long id){
        service.deleteSchedules(id);
        return ResponseEntity.ok("Schedule Deleted Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedules> updateSchedule(@PathVariable Long id,@RequestBody ScheduleRequestDTO scheduleRequestDTO){
        return ResponseEntity.ok(service.updateSchedules(id,scheduleRequestDTO));
    }

    @GetMapping("/ship/{id}")
    public ResponseEntity<List<Schedules>> getScheduleByShipId(@PathVariable Long id)
    {
        List<Schedules> schedules = service.getSchedulesByShip(id);
        if(schedules.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(schedules);

    }

    @GetMapping("/route/{id}")
    public ResponseEntity<List<Schedules>> getScheduleByRouteId(@PathVariable Long id)
    {
        List<Schedules> schedules = service.getSchedulesByRouteId(id);
        if(schedules.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(schedules);

    }

    @ExceptionHandler(ScheduleNotFoundException.class)
    public ResponseEntity<?> scheduleNotFoundExceptionHandler(ScheduleNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            Map.of(
                "status:",404,
                "message",ex.getMessage()
            )
        );
    }
}
