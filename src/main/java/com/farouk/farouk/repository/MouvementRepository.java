package com.farouk.farouk.repository;

import com.farouk.farouk.model.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MouvementRepository extends JpaRepository<Mouvement, Long> {

    List<Mouvement> findByType(String type);
}
