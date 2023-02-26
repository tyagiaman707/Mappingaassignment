package com.example.Mapping.Dto;

import com.example.Mapping.Model.Address;
import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;
    private Address address;
}
