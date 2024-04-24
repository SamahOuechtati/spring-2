package tn.esprit.sprigproject.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.sprigproject.entities.Foyer;
import tn.esprit.sprigproject.entities.Universite;
import tn.esprit.sprigproject.repositories.FoyerRepository;
import tn.esprit.sprigproject.repositories.UniversiteRepository;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Transactional
public class UniversiteService  implements IUniversiteService {

    UniversiteRepository univers;
    FoyerRepository foyers;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return univers.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return univers.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return univers.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        Universite optionalUniversite = univers.findById(idUniversite).orElse(null);
        return optionalUniversite;
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universite universite = univers.findByNomUniversite(nomUniversite);


            Foyer foyer = foyers.findById(idFoyer).get();

                universite.setFoyer(foyer);
                return univers.save(universite);


    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {

        Universite universite = univers.findById(idUniversite).get();

        if (universite != null) {

            universite.setFoyer(null);

            return universite;
        } else {
            return null;
        }

    }
}

