package org.example.corebankingsystem.controller;


import lombok.RequiredArgsConstructor;
import org.example.corebankingsystem.dto.UserDTO;
import org.example.corebankingsystem.dto.UserResponseDTO;
import org.example.corebankingsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO register(@RequestBody UserDTO userDto) {
        return userService.register(userDto);
    }



    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers();
    }

}
