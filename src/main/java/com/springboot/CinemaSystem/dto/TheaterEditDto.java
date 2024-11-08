package com.springboot.CinemaSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TheaterEditDto {
    private long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String ward;
    private String district;
    private String city;
    private String description;
}
