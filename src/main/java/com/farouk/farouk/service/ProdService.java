package com.farouk.farouk.service;

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
    public Produits update(String nom, String code, Integer stock,long idBoutique) {
        Produits existing = produitRepository.findByNom(nom)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        existing.setCode(code);
        existing.setStock(stock);

        if (idBoutique != 0) {
            Boutiques boutique = boutiqueRepository.findById(idBoutique)
                    .orElseThrow(() -> new RuntimeException("Boutique non trouvée"));
            existing.setBoutique(boutique);
        }


        return produitRepository.saveAndFlush(existing);
    }
   public void delete(String nomP){
       Optional<Produits> produitOptional = produitRepository.findByCode(nomP);
        if(produitOptional.isEmpty()){
            System.out.println("le produit du nom "+nomP+" n'existe pas");
            return;
        }
            Produits produittrouver = produitOptional.get();
            produitRepository.deleteByCode(nomP);
            System.out.println("vous aviez supp le produit "+ produittrouver.getNom()+" avec succe!!!");
   }

}
