package com.farouk.farouk.model;
import jakarta.persistence.*;


import lombok.*;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Depenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String motif;
    Float montant;
}
