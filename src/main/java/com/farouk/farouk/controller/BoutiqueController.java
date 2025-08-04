package com.farouk.farouk.controller;

import com.farouk.farouk.model.Boutiques;
import com.farouk.farouk.service.BoutiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farouk")
public class BoutiqueController {
    @Autowired
    private BoutiqueService boutiqueService;
    @GetMapping("/listeBoutiques")
    public List<Boutiques> listeBoutiques(){
        return boutiqueService.findAll();
    }
    @PostMapping("/saveBoutique")
    public Boutiques create(@RequestBody Boutiques boutique){
        return boutiqueService.createBoutique(boutique);
    }
    @PostMapping("/updateBoutique")
    public Boutiques update(@RequestBody Boutiques boutique){
        return boutiqueService.update(boutique);
    }
    @DeleteMapping("/deleteBoutique")
    public void deleteBoutique(@RequestBody long id){
        boutiqueService.delete(id);
    }
}
