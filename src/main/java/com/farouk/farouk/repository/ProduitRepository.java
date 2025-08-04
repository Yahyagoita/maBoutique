package com.farouk.farouk.repository;

import com.farouk.farouk.model.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends JpaRepository<Produits,Long> {

    Optional<Produits> findByNom(String nom);

    Optional<Produits> findByCode(String code);

    void deleteByCode(String code);

    boolean existsByCode(String code);
}
