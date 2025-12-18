package com.oceanLink.service.users;

import com.oceanLink.dto.UserDTO;
import com.oceanLink.model.User;
import com.oceanLink.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userrepo;
    @Override
    public User createUser(User user) {
        userrepo.save(user);
        return user;
    }

    @Override
    public List<UserDTO> findAllUser() {
        List<UserDTO>  dtos = userrepo.findAll().stream()
                .map(user->
                        new UserDTO(
                                user.getFullName(),
                                user.getEmail(),
                                user.getPhno(),
                                user.getAddress()
                        )
                ).toList();
        return dtos;
    }

    @Override
    public Optional<UserDTO> findUserById(int id) {
        return userrepo.findById(id)
                .map(user -> new UserDTO(
                        user.getFullName(),
                        user.getEmail(),
                        user.getPhno(),
                        user.getAddress()
                ));
    }


}
