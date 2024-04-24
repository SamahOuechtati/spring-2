package tn.esprit.sprigproject.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.sprigproject.entities.Bloc;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Etudiant;
import tn.esprit.sprigproject.entities.Foyer;
import tn.esprit.sprigproject.repositories.BlocRepository;
import tn.esprit.sprigproject.repositories.ChambreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class BlocService implements IBlocService {

    BlocRepository blocc;
    ChambreRepository chmbRep;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocc.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocc.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocc.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocc.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocc.deleteById(idBloc);

    }
@Transactional
    @Override
    public Bloc affecterChambresABloc( Long idBloc, List<Long> numChambres) {
        Bloc bloc = blocc.findById(idBloc).orElse(null);




        List<Chambre> chambres =  chmbRep.findAllByNumeroChambreIn(numChambres);
        for (Chambre chambre: chambres){
            chambre.setBloc(bloc);

        }
    blocc.save(bloc);

        return bloc;


    }


}
