package com.farouk.farouk.repository;

import com.farouk.farouk.model.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateurs, Long> {
}
