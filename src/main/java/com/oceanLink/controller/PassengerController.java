package com.oceanLink.controller;

import com.oceanLink.dto.passenger.PassengerDTO;
import com.oceanLink.model.Passenger;
import com.oceanLink.service.passenger.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    PassengerService service;
    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody PassengerDTO pass){
        return ResponseEntity.ok(service.addPassenger(pass));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPassengerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id){
        service.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("booking/{bookingId}")
    public ResponseEntity<List<Passenger>> getAllPassengerByBookingId(@PathVariable Long bookingId){
        List<Passenger> list= service.getPassengersByBookingId(bookingId);
        if(list.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id,@RequestBody PassengerDTO dto){
        return ResponseEntity.ok(service.updatePassenger(id,dto));
    }


}
