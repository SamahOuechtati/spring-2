package tn.esprit.sprigproject.services;

import tn.esprit.sprigproject.entities.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservation();

    Reservation updateReservation(Reservation res);

    Reservation retrieveReservation(Long idReservation);

//    Reservation addRes(Reservation res);
//    public Reservation ajouterReservation (long idChambre, long cinEtudiant) ;

    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite);

    //    public Reservation ajouterReservation (Long idChambre, long cinEtudiant) ;
//    public Reservation ajouterReservation(long idBloc, long cinEtudiant);
}
