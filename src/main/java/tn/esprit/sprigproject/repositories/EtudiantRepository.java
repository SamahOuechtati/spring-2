package tn.esprit.sprigproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.sprigproject.entities.Etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

   Etudiant findByCin(long cinEtudiant);


}
