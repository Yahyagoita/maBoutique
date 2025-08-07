package com.farouk.farouk.service;

import com.farouk.farouk.dao.MouvementDto;
import com.farouk.farouk.mapper.MouvementMapper;
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
    @Autowired
    MouvementMapper mouvementMapper;

    public List<Mouvement> getAllMouvements() {
        return mouvRepository.findAll();
    }
    public List<Mouvement> byType(@RequestParam String type) {
        return mouvRepository.findByType(type);
    }

    public Mouvement entreSortie(MouvementDto dto) {
        Produits produit = produitRepository.findByNom(dto.getNomProduit()).orElseThrow(()-> new RuntimeException("Produit non trouvé"));
        Mouvement mouvement = new Mouvement();
        mouvement.setType(dto.getType());
        if ("ENTRE".equalsIgnoreCase(mouvement.getType())) {
            if (dto.getQte() <= 0) {
                System.out.println("dans une entre il faut la quantity");
            }
           mouvement.setQte(dto.getQte());
           mouvement.setProduit(produit);
        } else if ("SORTIE".equalsIgnoreCase(mouvement.getType())) {
            if (produit.getStock() < dto.getQte() || dto.getQte() <= 0) {
                System.out.println("Stock insuffisant ou la qte est <= 0 pour le produit " + produit.getNom());
            }
            produit.setStock(produit.getStock() - dto.getQte());
            mouvement.setQte(dto.getQte());
            mouvement.setProduit(produit);
        } else if ("DEPENSE".equalsIgnoreCase(mouvement.getType())) {
            if (dto.getDescription() == null || "".equals(dto.getDescription())) {
                System.out.println("donner le motif de la depende ");
            }
            mouvement.setDescription(dto.getDescription());
            mouvement.setMontant(dto.getMontant());
        } else {
            System.out.println("Type de mouvement inconnu : " + mouvement.getType());
        }
        produitRepository.saveAndFlush(produit);
        System.out.println("Stock mis à jour avec succès pour " + produit.getNom());
        return mouvRepository.saveAndFlush(mouvement);
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
