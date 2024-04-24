package tn.esprit.sprigproject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Reservation;
import tn.esprit.sprigproject.entities.Universite;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository <Reservation, Long> {

    @Query("SELECT r FROM Chambre c " +
            "JOIN c.reservations r " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE CAST(r.anneeUniversitaire AS string) LIKE %?1% AND u.nomUniversite = ?2")
    public List<Reservation> findReservationByNomUniversite(LocalDate anneeUniversite, String nomUniversite);

//    public List<Reservation> findfo


}
