package com.farouk.farouk.controller;

import com.farouk.farouk.model.Produits;
import com.farouk.farouk.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/farouk")
public class ProdController {
    @Autowired
    private ProdService prodService;
    @GetMapping("/listeP")
    public List<Produits>  listeProduits(){
        return prodService.findAll();
    }
    @PostMapping("/saveP")
    public Produits save(@RequestBody Produits p){
        return prodService.save(p);
    }
    @PostMapping("/updateP")
    public Produits updateProduit(@RequestParam String nom,@RequestParam String code,@RequestParam Integer stock,@RequestParam long idBoutique){
        return prodService.update(nom,code,stock,idBoutique);
    }
    @DeleteMapping("/deleteP")
    public void deleteProduit(@RequestBody String nomP){
        prodService.delete(nomP);
    }

}
