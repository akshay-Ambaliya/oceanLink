package com.oceanLink.service.schedules;

import com.oceanLink.dto.schedule.ScheduleRequestDTO;
import com.oceanLink.model.Schedules;

import java.util.List;

public interface ScheduleSevice {
    Schedules createSchedule (ScheduleRequestDTO requestDTO);

    List<Schedules> getAllSchedules();

    Schedules getScheduleById(Long id);

    Schedules updateSchedules( long id,ScheduleRequestDTO dto);

    void deleteSchedules(Long id);

    List<Schedules> getSchedulesByRouteId(Long routeId);

    List<Schedules> getSchedulesByShip(Long shipId);
}
