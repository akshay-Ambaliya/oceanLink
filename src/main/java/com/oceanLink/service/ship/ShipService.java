package com.oceanLink.service.ship;

import com.oceanLink.model.Ship;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ShipService {

    Ship insertShip(Ship ship);

    List<Ship> getAllShip();

    Optional<Ship> getShipById(long id);

    Optional<Ship> updateShip(Ship ship,long id);

    boolean deleteShip(long id);

}
