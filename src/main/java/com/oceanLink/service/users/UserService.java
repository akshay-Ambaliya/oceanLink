package com.oceanLink.service.users;

import com.oceanLink.dto.UserDTO;
import com.oceanLink.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User users);
    List<UserDTO> findAllUser();

    Optional<UserDTO> findUserById(int id);

    Optional<UserDTO> updateUser(UserDTO userDTO,int ind);

    boolean deleteUser(int id);
}
