package com.finder.finderapi.users;

import com.finder.finderapi.exptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    UsersRepository repository;

    public void changeToAdmin(Long user_id) {
        Optional<UsersEntity> optionalUser = repository.findById(user_id);
        if (optionalUser.isPresent()) {
            UsersEntity user = optionalUser.get();
            user.setRole(UsersRoles.ADMIN);
            repository.save(user);
        } else {
            throw new UserNotFoundException("Usuário não encontrado", user_id);
        }
    }
}