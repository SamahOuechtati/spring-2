package tn.esprit.sprigproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.sprigproject.entities.Universite;

import java.util.List;

@Repository

public interface UniversiteRepository  extends JpaRepository <Universite, Long> {




     Universite findByNomUniversite(String nomUniversite);

     Universite findAllByIdUniversite(long idUniversite);


}
