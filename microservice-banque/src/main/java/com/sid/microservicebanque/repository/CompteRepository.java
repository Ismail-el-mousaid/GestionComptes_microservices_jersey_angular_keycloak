package com.sid.microservicebanque.repository;

import com.sid.microservicebanque.entities.Compte;
import com.sid.microservicebanque.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    public List<Compte> findByType(TypeCompte type);
}
