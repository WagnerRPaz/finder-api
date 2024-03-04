package com.finder.finderapi.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;

    @PostMapping("/changeToAdmin/{user_id}")
    public ResponseEntity<?> changeToAdmin(@PathVariable Long user_id) {
        service.changeToAdmin(user_id);
        return ResponseEntity.ok().build();
    }
}