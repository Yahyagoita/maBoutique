package com.farouk.farouk.controller;

import com.farouk.farouk.model.Mouvement;
import com.farouk.farouk.service.MouvService;
import com.farouk.farouk.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/props")
public class MouvController {
    @Autowired
    MouvService  mouvservice;
    @Autowired
    ProdService prodservice;
    @GetMapping("/listeM")
    public List<Mouvement> listeMouvement(){
        return  mouvservice.getAllMouvements();
    }
    @GetMapping("/listeTM")
    public List<Mouvement> byType(@RequestParam String type){
        return  mouvservice.byType(type);
    }

    //@PostMapping("/saveMouvement")
    @PostMapping("/entreStortie")
    public Mouvement entreStortie(@RequestParam String nomP, @RequestParam Integer qteP, @RequestParam String typeP,@RequestParam Integer prix) {
        return mouvservice.entreSortie(nomP,qteP,typeP,prix);
    }
    @PostMapping("/updateM")
    public Mouvement update(Mouvement m){
        return mouvservice.update(m);
    }
    @DeleteMapping("/deleteM")
    public void deleteMouvement(@RequestParam long id){
        mouvservice.deleteMouvement(id);
    }






    //@GetMapping ("/fairemouvement")
    // public String showFaireMouvement(Model model){
    //    model.addAttribute("mouvement",new Mouvement());
    //    return "mouvementVue";
    // }

}
