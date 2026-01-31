package org.example.corebankingsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.corebankingsystem.dto.UserDTO;
import org.example.corebankingsystem.dto.UserResponseDTO;
import org.example.corebankingsystem.entity.User;
import org.example.corebankingsystem.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponseDTO register(UserDTO userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use");
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setCreatedAt(new Date());

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }


    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private UserResponseDTO mapToResponse(User user) {
        UserResponseDTO resp = new UserResponseDTO();
        resp.setId(user.getId());
        resp.setFirstName(user.getFirstName());
        resp.setLastName(user.getLastName());
        resp.setEmail(user.getEmail());
        resp.setCreatedAt(user.getCreatedAt());
        return resp;
    }
}