package com.finder.finderapi.security;

import com.finder.finderapi.users.LoginResponseDTO;
import com.finder.finderapi.users.UsersEntity;
import com.finder.finderapi.users.UsersRepository;
import com.finder.finderapi.users.UsersRoles;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService service;
    @Autowired
    UsersRepository repository;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var userPassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userPassword);

        var token = service.gerateToken((UsersEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByEmail(data.email()) != null)return ResponseEntity.badRequest().build();

        UsersRoles userRole = UsersRoles.USER;
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UsersEntity newUser = new UsersEntity(data.nome(), data.email(), encryptedPassword, data.telefone(), userRole);

        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}