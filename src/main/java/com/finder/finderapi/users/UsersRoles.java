package com.finder.finderapi.users;

import lombok.Getter;

@Getter
public enum UsersRoles {
    ADMIN("ADMIN"),
    USER("USER");
    private final String role;

    UsersRoles (String role){
        this.role= role;
    }

}
