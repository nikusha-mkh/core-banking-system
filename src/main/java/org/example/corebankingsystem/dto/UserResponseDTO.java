package org.example.corebankingsystem.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date createdAt;

}
