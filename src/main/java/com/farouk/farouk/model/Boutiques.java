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
public class Boutiques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomB;
    private String tel;

    @OneToMany(mappedBy = "boutique",cascade = CascadeType.ALL)
    @JsonBackReference(value = "boutique-produits")
    private List<Produits> Produits;

}
