package tn.esprit.sprigproject.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.sprigproject.entities.Etudiant;

import java.util.List;
import java.util.Optional;

public interface IEtudiantService {


     List<Etudiant> retrieveAllEtudiants();
     List<Etudiant> addEtudiants (Etudiant e);
     Etudiant updateEtudiant (Etudiant e );
    Etudiant retrieveEtudiant(long  idEtudiant);
     void removeEtudiant(long idEtudiant);


}
