package com.oceanLink.repository;

import com.oceanLink.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepo extends JpaRepository<Ship, Long> {
}
