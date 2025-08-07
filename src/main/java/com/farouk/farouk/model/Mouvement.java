package com.farouk.farouk.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import  jakarta.persistence.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //Date date;
    String type;
    String description;
    Integer qte;
    Integer montant;
    Integer prix;


    @ManyToOne
    @JoinColumn(name = "nameProduit")
    @JsonBackReference
    private Produits produit;
}
