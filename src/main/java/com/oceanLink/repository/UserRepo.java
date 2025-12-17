package com.oceanLink.repository;

import com.oceanLink.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Integer> {

}
