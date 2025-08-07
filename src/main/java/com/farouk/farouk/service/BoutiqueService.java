package com.farouk.farouk.service;

import com.farouk.farouk.model.Boutiques;
import com.farouk.farouk.repository.BoutiqueRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoutiqueService {
    @Autowired
    private BoutiqueRepository boutiqueRepository;
public List<Boutiques> findAll(){
    return boutiqueRepository.findAll();
}
public Boutiques findById(Long id){
    return boutiqueRepository.findById(id).orElseThrow(()->new EntityNotFoundException("id " +id+" not found"));
}
public Boutiques createBoutique(Boutiques boutiques){
    return boutiqueRepository.saveAndFlush(boutiques);
}
public Boutiques update(Boutiques boutiques){
    Boutiques existing = boutiqueRepository.findById(boutiques.getId()).orElseThrow(()->new RuntimeException("Boutique not found!!"));
    existing.setNomB(boutiques.getNomB());
    existing.setTel(boutiques.getTel());
    return boutiqueRepository.saveAndFlush(existing);
}
public void delete(Long id){
    Boutiques boutiques = boutiqueRepository.findById(id).orElseThrow(()->new RuntimeException("Boutique not found!!"));
    boutiqueRepository.delete(boutiques);
    System.out.println("Boutique " + boutiques.getId() + " a ete bien sup");
}
}
