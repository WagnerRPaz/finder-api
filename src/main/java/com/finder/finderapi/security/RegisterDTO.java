package com.finder.finderapi.security;

import com.finder.finderapi.users.UsersRoles;

public record RegisterDTO(String nome, String email, String password, Integer telefone, UsersRoles role) {
}
