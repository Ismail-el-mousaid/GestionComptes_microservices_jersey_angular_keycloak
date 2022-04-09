package com.sid.microservicebanque.service;

import com.sid.microservicebanque.entities.Compte;
import com.sid.microservicebanque.entities.TypeCompte;
import com.sid.microservicebanque.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BanqueServiceImpl implements IBanqueService{
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    @Override
    public Compte getCompte(Long id) {
        return compteRepository.findById(id).get();
    }

    @Override
    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public Compte updateCompte(Long id, Compte compte) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    @Override
    public List<Compte> getComptesByType(TypeCompte typeCompte) {
        return compteRepository.findByType(typeCompte);
    }
}
