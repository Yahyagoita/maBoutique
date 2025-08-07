package com.farouk.farouk.service;

import com.farouk.farouk.dao.ProduitsDto;
import com.farouk.farouk.model.Boutiques;
import com.farouk.farouk.model.Produits;
import com.farouk.farouk.repository.BoutiqueRepository;
import com.farouk.farouk.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdService {
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private BoutiqueRepository boutiqueRepository;
    public List<Produits> findAll(){
        return produitRepository.findAll();
    }
    public Produits save(Produits p){
        return produitRepository.saveAndFlush(p);
    }
    public Produits update(ProduitsDto pDto) {
        Produits existing = produitRepository.findByNom(pDto.getNom())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        existing.setCode(pDto.getCode());
        existing.setStock(pDto.getStock());

        if (pDto.getIdBoutique() != 0) {
            Boutiques boutique = boutiqueRepository.findById(pDto.getIdBoutique())
                    .orElseThrow(() -> new RuntimeException("Boutique non trouvée"));
            existing.setBoutique(boutique);
        }

        return produitRepository.saveAndFlush(existing);
    }
   public void delete(String nomP){
       Produits produit = produitRepository.findByNom(nomP).orElseThrow(()-> new RuntimeException("le produit que vous voulez supp is not found"));
            produitRepository.deleteByCode(nomP);
            System.out.println("vous aviez supp le produit "+ produit.getNom()+" avec succe!!!");
   }

}
