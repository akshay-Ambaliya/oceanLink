package com.oceanLink.service.users;

import com.oceanLink.dto.user.UserDTO;
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
    public Optional<UserDTO> findUserById(Long id) {
        return userrepo.findById(id)
                .map(user -> new UserDTO(
                        user.getFullName(),
                        user.getEmail(),
                        user.getPhno(),
                        user.getAddress()
                ));
    }

    @Override
    public Optional<UserDTO> updateUser(UserDTO user,Long id) {

        Optional<User> temp = userrepo.findById(id);

        if(temp.isEmpty())
            return Optional.empty();

        User existed = temp.get();

        existed.setFullName(user.getFullName());
        existed.setEmail(user.getEmail());
        existed.setPhno(user.getPhno());
        existed.setAddress(user.getAddress());

        return Optional.of(new UserDTO(
            existed.getFullName(),
            existed.getEmail(),
            existed.getPhno(),
            existed.getAddress()
        ));
    }

    @Override
    public boolean deleteUser(long id) {

        if(userrepo.existsById(id))
        {
            userrepo.deleteById(id);
            return true;
        }
        return false;
    }
}
