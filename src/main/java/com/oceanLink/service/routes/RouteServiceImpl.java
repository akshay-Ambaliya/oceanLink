package com.oceanLink.service.routes;

import com.oceanLink.model.Route;
import com.oceanLink.repository.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService{
    @Autowired
    RouteRepo repo;

    @Override
    public Route addRoute(Route route) {
        return repo.save(route);
    }

    @Override
    public List<Route> getAllRoutes() {
        return repo.findAll();
    }

    @Override
    public Optional<Route> getRouteById(long id) {
        return repo.findById(id);
    }

    @Override
    public boolean deleteRoute(long id) {
        if(repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Route updateRoute(long id,Route route) {
        if(repo.existsById(id)){
            Route existed = repo.findById(id).get();
            existed.setDestination(route.getDestination());
            existed.setDuration(route.getDuration());
            existed.setSource(route.getSource());
            existed.setDistance(route.getDistance());

            return repo.save(existed);
        }else{
            return null;
        }
    }
}
