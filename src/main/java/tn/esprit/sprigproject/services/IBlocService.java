package tn.esprit.sprigproject.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.sprigproject.entities.Bloc;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Foyer;

import java.util.List;
import java.util.Optional;

public interface IBlocService {

    List<Bloc> retrieveBlocs();
    Bloc updateBloc (Bloc bloc);
    Bloc addBloc (Bloc bloc);
    Bloc retrieveBloc (long idBloc);
    void removeBloc (long idBloc);
    public Bloc affecterChambresABloc( Long
            idBloc,List<Long> numChambre) ;


}
