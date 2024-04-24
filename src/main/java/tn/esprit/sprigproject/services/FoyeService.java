package tn.esprit.sprigproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.sprigproject.entities.Bloc;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Foyer;
import tn.esprit.sprigproject.entities.Universite;
import tn.esprit.sprigproject.repositories.FoyerRepository;
import tn.esprit.sprigproject.repositories.UniversiteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class FoyeService implements  IFoyerService {


    FoyerRepository foy;
    UniversiteRepository servUni;
    BlocService blc;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foy.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foy.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foy.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        Optional<Foyer> OptinelIdFoyer = foy.findById(idFoyer);
        return OptinelIdFoyer.orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foy.deleteById(idFoyer);

    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {

        Universite universite = servUni.findAllByIdUniversite(idUniversite);

            foyer.setUniversite(universite);
            universite.setFoyer(foyer);
           return foy.save(foyer);




    }



        }




