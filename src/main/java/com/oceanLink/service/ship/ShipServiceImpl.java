package com.oceanLink.service.ship;

import com.oceanLink.model.Ship;
import com.oceanLink.repository.ShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ShipServiceImpl implements ShipService{

    @Autowired
    ShipRepo repo;

    @Override
    public Ship insertShip(Ship ship) {
        return repo.save(ship);
    }

    @Override
    public List<Ship> getAllShip() {
        return repo.findAll();
    }

    @Override
    public Optional<Ship> getShipById(long id) {
        return repo.findById(id);
    }

    @Override
    public Optional<Ship> updateShip(Ship ship,long id) {
        Optional<Ship> existed = repo.findById(id);
        if(existed.isEmpty())
            return Optional.empty();

        Ship temp = existed.get();

        temp.setShipName(ship.getShipName());
        temp.setCapacity(ship.getCapacity());
        temp.setDescription(ship.getDescription());
        temp.setStatus(ship.getStatus());

        return Optional.of(repo.save(temp));
    }

    @Override
    public boolean deleteShip(long id) {
        Optional<Ship> ship = repo.findById(id);

        if(ship.isEmpty())
            return false;

        repo.deleteById(id);
        return true;
    }
}
