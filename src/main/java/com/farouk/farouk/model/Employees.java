package com.farouk.farouk.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name ;
    private  String surname;
    private String email;
    private String password;

}
