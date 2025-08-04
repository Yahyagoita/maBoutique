package com.farouk.farouk.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Produits {
    String code;
    @Id
    String nom;
    int stock;

    public Produits(String code,String nom, Integer stock) {
        this.code = code;
        this.nom = nom;
        this.stock = stock;
    }
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Mouvement> mouvement;

    @ManyToOne
    @JoinColumn(name = "boutique")
    @JsonBackReference(value = "boutique-produits")
    private Boutiques boutique;
}
