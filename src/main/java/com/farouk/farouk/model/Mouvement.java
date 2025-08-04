package com.farouk.farouk.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import  jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mouvement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //Date date;
    String type;
    Integer qte;
    Integer montant;
    Integer prix;

    public Mouvement(String type, Integer qte, Integer montant, Integer prix) {
        this.type = type;
        this.qte = qte;
        this.montant = montant;
        this.prix = prix;
    }

    @ManyToOne
    @JoinColumn(name = "nameProduit")
    @JsonBackReference
    private Produits produit;
}
