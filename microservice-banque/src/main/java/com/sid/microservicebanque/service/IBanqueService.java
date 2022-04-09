package com.sid.microservicebanque.service;

import com.sid.microservicebanque.entities.Compte;
import com.sid.microservicebanque.entities.TypeCompte;

import java.util.List;

public interface IBanqueService {
    public List<Compte> getComptes();
    public Compte getCompte(Long id);
    public Compte saveCompte(Compte compte);
    public Compte updateCompte(Long id, Compte compte);
    public void deleteCompte(Long id);
    public List<Compte> getComptesByType(TypeCompte typeCompte);
}
