package tn.esprit.sprigproject.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprigproject.entities.Etudiant;
import tn.esprit.sprigproject.repositories.EtudiantRepository;
import tn.esprit.sprigproject.services.EtudiantSrvice;
import tn.esprit.sprigproject.services.IEtudiantService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/etudiants")

public class EtudiantController {

    @Autowired
    EtudiantSrvice etu;

    @PostMapping
    public List<Etudiant> addEtudiant (@RequestBody Etudiant etudiant){
        return etu.addEtudiants(etudiant);
    }

    @GetMapping
    public List<Etudiant> GetAllEtudiant(){
        return etu.retrieveAllEtudiants();
    }


    @GetMapping("{id}")
    public Etudiant GetbyIdEtudiant (@PathVariable Long id){
        return etu.retrieveEtudiant(id);
    }


    @DeleteMapping("{id}")
    void   suppById(@PathVariable Long id) {
         etu.removeEtudiant(id);
    }


    @PutMapping("{id}")
    public Etudiant putByIdEtud(@PathVariable Long id, @RequestBody Etudiant e) {
        return etu.updateEtudiant(e);
    }




}
