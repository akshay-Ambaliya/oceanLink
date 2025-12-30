package com.oceanLink.service.users;

import com.oceanLink.dto.user.UserDTO;
import com.oceanLink.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User users);
    List<UserDTO> findAllUser();

    Optional<UserDTO> findUserById(Long id);

    Optional<UserDTO> updateUser(UserDTO userDTO,Long ind);

    boolean deleteUser(long id);
}
