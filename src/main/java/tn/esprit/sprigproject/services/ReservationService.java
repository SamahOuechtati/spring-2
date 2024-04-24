package tn.esprit.sprigproject.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.sprigproject.entities.*;
import tn.esprit.sprigproject.repositories.BlocRepository;
import tn.esprit.sprigproject.repositories.ChambreRepository;
import tn.esprit.sprigproject.repositories.EtudiantRepository;
import tn.esprit.sprigproject.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class ReservationService  implements IReservationService {

    ReservationRepository res;
    EtudiantRepository etures;
    ChambreRepository chamb;
    BlocRepository blc;


    @Override
    public List<Reservation> retrieveAllReservation() {
        return res.findAll();
    }

    @Override
    public Reservation updateReservation(Reservation reser) {
        return res.save(reser);
    }

    @Override
    public Reservation retrieveReservation(Long idReservation) {
        Optional<Reservation> optionalRes = res.findById(idReservation);
        return optionalRes.orElse(null);
    }

//    @Override
//    public Reservation addRes(Reservation ress) {
//        return res.save(ress);
//    }


    @Override

    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(LocalDate anneeUniversite, String nomUniversite) {
        return res.findReservationByNomUniversite(anneeUniversite, nomUniversite);
    }

//    @Override
//    public Reservation ajouterReservation(long idChambre, long cinEtudiant) {
//
//        if (res.findById(idChambre).isPresent()) {
//            Reservation reservation = res.findById(idChambre).orElse(null);
//            assert reservation != null;
//            reservation.getEtudiant().add(etures.findById(cinEtudiant).orElse(null));
//            Chambre chambre = chamb.findByReservationsAndIdChambre(idChambre);
//            switch (chambre.getTypeC()) {
//                case Triple:
//
//                    if (reservation.getEtudiant().size() == 3) {
//                        reservation.setEstValide(false);
//                    }
//                    break;
//                case Double:
//                    reservation.setEstValide(false);
//                    break;
//
//            }
//            return res.save(reservation);
//        } else {
//            List<Etudiant> etudiants = new ArrayList<Etudiant>();
//            etudiants.add(etures.findByCin(cinEtudiant));
//            Reservation reservation = Reservation.builder().anneeUniversitaire(LocalDate.now()).etudiants(etudiants).build();
//            Chambre chambre = (Chambre) chamb.getFirstByReservations(idChambre);
//            Bloc bloc = blc.findById(chambre.getBloc().getIdBloc()).get();
//
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(new Date());
//
//            String idReservation = chambre.getIdChambre() + bloc.getNomBloc() + calendar.get(calendar.YEAR);
//            reservation.setIdReservation(Long.valueOf(idReservation));
//            if (chambre.getTypeC().equals(TypeChambre.Simple)) {
//                reservation.setEstValide(false);
//            } else {
//                reservation.setEstValide(true);
//
//            }
//            return res.save(reservation);
//        }
//
//
//    }
}





