package com.oceanLink.service.schedules;

import com.oceanLink.dto.schedule.ScheduleRequestDTO;
import com.oceanLink.exception.Route.RouteNotFoundException;
import com.oceanLink.exception.Schedule.ScheduleNotFoundException;
import com.oceanLink.exception.Ship.ShipNotFoundException;
import com.oceanLink.model.Route;
import com.oceanLink.model.Schedules;
import com.oceanLink.model.Ship;
import com.oceanLink.repository.RouteRepo;
import com.oceanLink.repository.ScheduleRepo;
import com.oceanLink.repository.ShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleSevice{

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ShipRepo shipRepo;

    @Autowired
    RouteRepo routeRepo;

    @Override
    public Schedules createSchedule(ScheduleRequestDTO requestDTO) {
        Ship ship = shipRepo.findById(requestDTO.getShipId())
                .orElseThrow(()->new ShipNotFoundException(requestDTO.getShipId()));

        Route route = routeRepo.findById(requestDTO.getRouteId())
                .orElseThrow(()->new RouteNotFoundException(requestDTO.getRouteId()));

        Schedules schedule = new Schedules();
        schedule.setShip(ship);
        schedule.setArrival(requestDTO.getArrival());
        schedule.setDeparture(requestDTO.getDeparture());
        schedule.setRoute(route);
        schedule.setPrice(requestDTO.getPrice());
        return scheduleRepo.save(schedule);
    }

    @Override
    public List<Schedules> getAllSchedules() {
        return scheduleRepo.findAll();
    }

    @Override
    public Schedules getScheduleById(Long id) {
        return scheduleRepo.findById(id).orElseThrow(()->new ScheduleNotFoundException(id));
    }

    @Override
    public Schedules updateSchedules(long id, ScheduleRequestDTO dto) {

        Schedules schedules = scheduleRepo.findById(id).orElseThrow(()-> new ScheduleNotFoundException(id));
        Ship ship = shipRepo.findById(dto.getRouteId()).orElseThrow(()-> new ShipNotFoundException(dto.getShipId()));
        Route route = routeRepo.findById(dto.getRouteId()).orElseThrow(()-> new RouteNotFoundException(dto.getRouteId()));

        schedules.setPrice(dto.getPrice());
        schedules.setArrival(dto.getArrival());
        schedules.setDeparture(dto.getDeparture());
        schedules.setShip(ship);
        schedules.setRoute(route);

        return scheduleRepo.save(schedules);

    }

    @Override
    public void deleteSchedules(Long id){
        if(!scheduleRepo.existsById(id)){
            throw new ScheduleNotFoundException(id);
        }
        scheduleRepo.deleteById(id);
    }

    @Override
    public List<Schedules> getSchedulesByRouteId(Long routeId) {
        if(!routeRepo.existsById(routeId)){
            throw  new RouteNotFoundException(routeId);
        }
        return scheduleRepo.findByShip_ShipId(routeId);
    }

    @Override
    public List<Schedules> getSchedulesByShip(Long shipId) {
        if(!shipRepo.existsById(shipId)){
            throw  new ShipNotFoundException(shipId);
        }

        return scheduleRepo.findByRoute_RouteId(shipId);
    }
}
