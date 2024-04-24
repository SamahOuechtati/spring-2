package tn.esprit.sprigproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprigproject.entities.Etudiant;
import tn.esprit.sprigproject.entities.Foyer;
import tn.esprit.sprigproject.entities.Universite;
import tn.esprit.sprigproject.services.EtudiantSrvice;
import tn.esprit.sprigproject.services.UniversiteService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/universites")

public class UniversiteController {

    @Autowired
    UniversiteService uni;

    @GetMapping
    public List<Universite> retrieveAllUniversities() {
        return uni.retrieveAllUniversities();
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return uni.addUniversite(universite);
    }

    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        universite.setIdUniversite(id);
        return uni.updateUniversite(universite);
    }

    @GetMapping("/{id}")
    public Universite retrieveUniversite(@PathVariable Long id) {
        return uni.retrieveUniversite(id);
    }

    @PutMapping("/affectFoyer")
    public Universite affecterFoyerAUniversite(@RequestParam("idFoy") long idFoy, @RequestParam("nomUniver") String nomUniver) {
//        String nomUniver = (String) requestBody.get("nomUniver");
//        long idFoy = ((Number) requestBody.get("idFoy")).longValue();
        return uni.affecterFoyerAUniversite(idFoy,nomUniver);

    }
    @PutMapping("/{idUniversite}/desaffectFoyer")
    public Universite desaffecterFoyerAUniversite(@PathVariable long idUniversite) {
        return uni.desaffecterFoyerAUniversite(idUniversite);
    }


}
