package tn.esprit.sprigproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprigproject.entities.Foyer;
import tn.esprit.sprigproject.entities.Universite;
import tn.esprit.sprigproject.services.FoyeService;

import java.util.List;

@RestController
@RequestMapping("/foyers")
public class FoyerController {

    @Autowired
    FoyeService foyers;

    @GetMapping
    public List<Foyer> retrieveAllFoyers(){
        return foyers.retrieveAllFoyers();
    }
    @PostMapping
    Foyer addFoyer(@RequestBody Foyer f){
        return  foyers.addFoyer(f);
    }
    @PutMapping("{id}")
    Foyer updateFoyer(@PathVariable Long id,@RequestBody Foyer f){
        f.setIdFoyer(id);
        return  foyers.updateFoyer(f);
    }
    @GetMapping("{id}")
    Foyer retrieveFoyerID(@PathVariable Long id,@RequestBody Foyer f){
        f.setIdFoyer(id);
        return foyers.retrieveFoyer(id);
    }

    @DeleteMapping("{id}")
    void removeFoyer(@PathVariable Long id){
        foyers.removeFoyer(id);

    }
    @PutMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajoutFoyeretAffecterchambre(@PathVariable("idUniversite") long idUniversite,@RequestBody Foyer foyer) {
        return foyers.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
    }

}
