package tn.esprit.sprigproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Etudiant;
import tn.esprit.sprigproject.entities.TypeChambre;
import tn.esprit.sprigproject.services.ChambreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chambres")
public class ChambreController {
    @Autowired
    ChambreService chambre;


    @PostMapping
    public Chambre addChambre(@RequestBody Chambre cham) {
        return chambre.addChambre(cham);

    }
    @GetMapping
    public List<Chambre> GetAllChambre(){
        return chambre.retrieveAllChambres();
    }

    @GetMapping("{id}")
    public Chambre GetByIdChambre(@PathVariable Long id){
        return chambre.retrieveChambre(id);
    }
    @PutMapping("{id}")
    public Chambre PutChambre (@PathVariable Long id,@RequestBody Chambre c){
        return chambre.updateChambre(c);
    }

    @DeleteMapping("{id}")
    void  suppByIdChambre(@PathVariable Long id) {
         chambre.deletechambre(id);

    }
    @GetMapping("get-by-univ/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return chambre.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("get-by-Bloc/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType (@PathVariable("idBloc") Long idBloc, @PathVariable("typeC") TypeChambre typeC)  {
        return chambre.getChambresParBlocEtType(idBloc,typeC);
    }
    @GetMapping("getResNonDéfinie/{nomUniversite}/{Type}")
    public List<Chambre> getChambreNonRes(@PathVariable("nomUniversite") String nomUniversite,@PathVariable("Type") TypeChambre type) {
        return  chambre.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite,type);
    };


}
