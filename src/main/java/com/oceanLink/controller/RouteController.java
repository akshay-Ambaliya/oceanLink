package com.oceanLink.controller;

import com.oceanLink.model.Route;
import com.oceanLink.service.routes.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    RouteService service;

    @PostMapping
    public ResponseEntity<Route> addRoute(@RequestBody Route route){
        return ResponseEntity.ok(service.addRoute(route));
    }

    @GetMapping
    public ResponseEntity<List<Route>> getAllRoutes(){
        List<Route> routes = service.getAllRoutes();
        if(routes.isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(routes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable long id){
        Optional<Route> route = service.getRouteById(id);
        return route.isEmpty()?
                ResponseEntity.notFound().build() :
                ResponseEntity.ok(route.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Route> deleteRoute(@PathVariable long id){
        if(service.deleteRoute(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable long id,@RequestBody Route route){
        Route resp = service.updateRoute(id,route);
        return resp!=null?
                ResponseEntity.ok(resp):
                ResponseEntity.notFound().build();
    }
}
