package com.oceanLink.repository;

import com.oceanLink.model.Schedules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedules,Long> {
    List<Schedules> findByShip_ShipId(Long shipId);
    List<Schedules> findByRoute_RouteId(Long routeId);
}
