package com.farouk.farouk.repository;

import com.farouk.farouk.model.Boutiques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutiques, Long> {
}
