package tn.esprit.sprigproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprigproject.entities.Bloc;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Etudiant;
import tn.esprit.sprigproject.services.BlocService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/blocs")

public class BlocController {

    @Autowired
    BlocService blc;

    @GetMapping
    public List<Bloc> GetAllChambre() {
        return blc.retrieveBlocs();
    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blc.addBloc(bloc);
    }

    @PutMapping("{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc b) {
        return blc.updateBloc(b);
    }

    @GetMapping("{id}")
    public Bloc GetIdBloc (@PathVariable Long id){
        return blc.retrieveBloc(id);

    }
    @DeleteMapping("{id}")
    void  suppByIdBloc (@PathVariable Long id){
         blc.removeBloc(id);
    }

    @PutMapping("affecterChambres/{idBloc}")
    public Bloc affecterChambresABloc(@PathVariable("idBloc") Long idBloc, @RequestBody List<Long> numChambres) {
       return   blc.affecterChambresABloc(idBloc,numChambres);

    }




}
