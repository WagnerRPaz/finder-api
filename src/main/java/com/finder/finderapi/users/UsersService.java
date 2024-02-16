package com.finder.finderapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    UsersRepository repository;

    public Object buscarTodos() {
        return repository.findAll();
    }
}