package com.farouk.farouk.dao;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ProduitsDto {
    String code;
    String nom;
    int stock;
    long idBoutique;
}
