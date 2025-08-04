package com.farouk.farouk.service;

import com.farouk.farouk.model.Mouvement;
import com.farouk.farouk.model.Produits;
import com.farouk.farouk.repository.MouvementRepository;
import com.farouk.farouk.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class MouvService {
    @Autowired
    MouvementRepository  mouvRepository;
    @Autowired
    ProdService prodService;
    @Autowired
    ProduitRepository produitRepository;

    public List<Mouvement> getAllMouvements() {
        return mouvRepository.findAll();
    }
    public List<Mouvement> byType(@RequestParam String type) {
        return mouvRepository.findByType(type);
    }

    public Mouvement entreSortie(String nomP, Integer qteP, String typeP,Integer prix) {
        Optional<Produits> produitOptional = produitRepository.findByNom(nomP);
        if (produitOptional.isEmpty()) {
            System.out.println("Produit non trouvé");
        }
        Produits produit = produitOptional.get();
        Mouvement m = new Mouvement();
        if ("ENTRE".equalsIgnoreCase(typeP)) {
            produit.setStock(produit.getStock() + qteP);
           // m.setPrix(null);m.setMontant(null);
        } else if ("SORTIE".equalsIgnoreCase(typeP)) {
            if (produit.getStock() < qteP) {
                System.out.println("Stock insuffisant pour le produit " + produit.getNom());
            }
            produit.setStock(produit.getStock() - qteP);

        } else {
            System.out.println("Type de mouvement inconnu : " + typeP);
        }
        produitRepository.saveAndFlush(produit);
        m.setQte(qteP); m.setProduit(produit); m.setType(typeP); m.setPrix(prix);m.setMontant(qteP*prix);
        System.out.println("Stock mis à jour avec succès pour " + produit.getNom());
        return mouvRepository.saveAndFlush(m);
    }
    public Mouvement update(Mouvement m) {
         Mouvement existing =  mouvRepository.findById(m.getId()).orElseThrow(() -> new RuntimeException("mouvement avec Id "+m.getId()+" est non trouvé"));
         existing.setMontant(m.getMontant());
         existing.setQte(m.getQte());
         existing.setPrix(m.getPrix());
         existing.setType(m.getType());
         existing.setProduit(m.getProduit());
         return mouvRepository.saveAndFlush(existing);
    }
    public void deleteMouvement (long id) {
         Mouvement existing = mouvRepository.findById(id).orElseThrow(() -> new RuntimeException("mouvement avec Id "+id+" est non trouvé"));
         mouvRepository.delete(existing);
         System.out.println("vous aviez supprimer le mouvement avec id "+ id);
    }
}
