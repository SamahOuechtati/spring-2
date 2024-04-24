package tn.esprit.sprigproject.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.sprigproject.entities.Chambre;
import tn.esprit.sprigproject.entities.Reservation;
import tn.esprit.sprigproject.entities.TypeChambre;
import tn.esprit.sprigproject.entities.Universite;

import java.util.List;


@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long > {

@Query("SELECT u FROM Chambre u WHERE u.numeroChambre IN ?1")
public List<Chambre> findAllByNumeroChambreIn(List<Long> numeroChambre);

    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE u.nomUniversite = ?1")
    public List<Chambre> findByNomUniversite(String nomUniversite);

//    public List<Chambre> findByBlocFoyerUniversiteNomUniversite(String nomUniversite);

    public List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);
    @Query("SELECT c FROM Chambre c " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "LEFT JOIN c.reservations r " + // Utilisation de LEFT JOIN pour inclure les chambres sans réservation
            "WHERE u.nomUniversite = :nomUniversite " +
            "AND c.typeC = :typeChambre " +
            "AND r.idReservation IS NULL") // Filtrer les chambres sans réservation
    public List<Chambre> getChambreNonRes(String nomUniversite, TypeChambre typeChambre);



//    @Modifying
//    @Transactional
//    @Query("UPDATE Chambre c SET c.reservations = :reservation WHERE c.idChambre = :idChambre")
//    void addReservationToChambre( Long idChambre,  Reservation reservation);


//public Chambre findByReservationsAndIdChambre(long idChambre);
//
//    @Query("SELECT c FROM Chambre c " +
//            "JOIN c.reservations r " +
//            "JOIN r.etudiant e " +
//
//            "WHERE e.idEtudiant = :idChambre")
//    List<Chambre> getFirstByReservations(@Param("idBloc") long idChambre);
//


}
