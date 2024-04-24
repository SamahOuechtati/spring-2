package tn.esprit.sprigproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprigproject.entities.Reservation;
import tn.esprit.sprigproject.services.ReservationService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/resrvations")
public class ReservationController {

    @Autowired
    ReservationService resevation;

    @GetMapping
    public List<Reservation> retrieveAllReservation() {
        return resevation.retrieveAllReservation();
    }

    @PutMapping("{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation res) {
        res.setIdReservation(id);
        return resevation.updateReservation(res);
    }

    @GetMapping("{id}")
    public Reservation retrieveReservation(@PathVariable Long id) {
        return resevation.retrieveReservation(id);
    }

//    @PostMapping
//    public Reservation addReservation(@RequestBody Reservation reserv) {
//        return resevation.addRes(reserv);
//    }

//    @PostMapping("/add")
//    public Reservation addReservationWithChambreAndEtudiant(@RequestParam long idChambre, @RequestParam long cinEtudiant) {
//        return resevation.ajouterReservation(idChambre, cinEtudiant);
//    }


    @GetMapping("{anneeUniversite}/{nomUniversite}")
    public List<Reservation> retrieveReservation(@PathVariable("anneeUniversite") LocalDate anneeUniversite, @PathVariable("nomUniversite") String nomUniversite) {
        return resevation.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversite, nomUniversite);
    }

//        @PostMapping("/add")
//    public Reservation addReservationWithChambreAndEtudiant(@RequestParam Long idChambre, @RequestParam long cinEtudiant) {
//        return resevation.ajouterReservation(idChambre, cinEtudiant);
//    }
//    @PostMapping("{idChambre}/{cinEtudiant}")
//    public Reservation ajouterReservation(@PathVariable("idChambre") long idChambre, @PathVariable("cinEtudiant") long cinEtudiant) {
//        return resevation.ajouterReservation(idChambre, cinEtudiant);
//
//    }
}