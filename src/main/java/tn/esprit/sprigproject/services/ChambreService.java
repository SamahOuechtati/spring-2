package tn.esprit.sprigproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.TypeChambre;
import tn.esprit.sprigproject.entities.Universite;
import tn.esprit.sprigproject.repositories.ChambreRepository;
import tn.esprit.sprigproject.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class ChambreService implements IChambreService {

    ChambreRepository ch;
    UniversiteRepository univrep;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return ch.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return ch.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return ch.save(c);
    }

    @Override
    public Chambre retrieveChambre(long idChambre) {
        return ch.findById(idChambre).orElse(null);
    }

    @Override
    public void deletechambre(long idchambre) {
        ch.deleteById(idchambre);

    }
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        System.out.println(nomUniversite);
        List<Chambre> chambres = ch.findByNomUniversite(nomUniversite);
//        List<Chambre> chambres = ch.findByBlocFoyerUniversiteNomUniversite(nomUniversite);
        System.out.print(chambres);
        return chambres;
    }


    public List<Chambre> getChambresParBlocEtType (Long idBloc, TypeChambre typeC){
        List<Chambre> chambres = ch.findByBlocIdBlocAndTypeC(idBloc, typeC);

        return chambres;

    }

    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite,TypeChambre type){

        List<Chambre> chambres=ch.getChambreNonRes(nomUniversite, type);

        return  chambres;
    }






}
