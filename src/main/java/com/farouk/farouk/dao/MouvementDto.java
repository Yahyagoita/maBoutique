package com.farouk.farouk.dao;

import lombok.Data;

@Data
public class MouvementDto {
    private String type;
    private String description;

    private Integer qte;
    private Integer prix;
    private Integer montant;

    private String nomProduit;
}
