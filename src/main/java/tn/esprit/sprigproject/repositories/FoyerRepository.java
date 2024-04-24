package tn.esprit.sprigproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.sprigproject.entities.Foyer;
import tn.esprit.sprigproject.entities.Universite;


@Repository
public interface FoyerRepository extends JpaRepository <Foyer, Long> {




}
