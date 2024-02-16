package com.finder.finderapi.users;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService service;

    @GetMapping
    public ResponseEntity<?>buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }
}