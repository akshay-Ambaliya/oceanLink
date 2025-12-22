package com.oceanLink.controller;

import com.oceanLink.model.Ship;
import com.oceanLink.service.ship.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ship")
public class ShipController {

    @Autowired
    ShipService service ;


    @PostMapping
    public ResponseEntity<Ship> insertShip(@RequestBody Ship ship){
        return ResponseEntity.ok(service.insertShip(ship));
    }

    @GetMapping
    public ResponseEntity<List<Ship>> getAllShips(){
        List<Ship> ships = service.getAllShip();
        if(ships.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(ships);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ship> getShipById(@PathVariable long id){
        Optional<Ship> ship = service.getShipById(id);
        if(ship.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(ship.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ship> updateShip(@RequestBody Ship ship,@PathVariable long id){
        Optional<Ship> temp = service.updateShip(ship,id);

        if(temp.isEmpty())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(temp.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ship> deleteShip(@PathVariable long id){
        if(service.deleteShip(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
