package com.oceanLink.service.users;

import com.oceanLink.model.User;
import com.oceanLink.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userrepo;
    @Override
    public User createUser(User users) {
        userrepo.save(users);
        return users;
    }
}
