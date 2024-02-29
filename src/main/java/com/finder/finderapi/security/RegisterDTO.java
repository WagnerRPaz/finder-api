package com.finder.finderapi.security;

import com.finder.finderapi.users.UsersRoles;

public record RegisterDTO(String name, String email, String password, UsersRoles role) {
}
