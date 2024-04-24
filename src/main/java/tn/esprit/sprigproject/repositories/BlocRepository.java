package tn.esprit.sprigproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.sprigproject.entities.Bloc;
import tn.esprit.sprigproject.entities.Universite;

public interface BlocRepository extends JpaRepository<Bloc, Long> {


//    Bloc findByNomBloc(String nomBloc);


}
