package tn.esprit.sprigproject.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Reservation;
import tn.esprit.sprigproject.entities.TypeChambre;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IChambreService {

    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);
    void deletechambre(long idchambre );
    public List<Chambre> getChambresParNomUniversite( String nomUniversite);

    public List<Chambre> getChambresParBlocEtType (Long idBloc, TypeChambre typeC) ;
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(
            String nomUniversite,TypeChambre type) ;

}
