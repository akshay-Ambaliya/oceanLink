package com.oceanLink.service.routes;

import com.oceanLink.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    Route addRoute(Route route);

    List<Route> getAllRoutes();

    Optional<Route> getRouteById(long id);

    boolean deleteRoute(long id);

    Route updateRoute(long id,Route route);
}
