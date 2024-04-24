package tn.esprit.sprigproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity
@Table (name = "reservation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation {



    @ManyToMany
    private List<Etudiant> etudiant;
    @JsonIgnore
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idReservation")

    Long idReservation;

    boolean estValide;
    String numReservation;
    @Temporal(TemporalType.DATE)
    LocalDate anneeUniversitaire;

    public static Reservation.ReservationBuilder builder() {
        return Reservation.ReservationBuilder.create();
    }

    public Reservation build() {
        return new Reservation(anneeUniversitaire, etudiant);
    }

    private Reservation(LocalDate anneeUniversitaire, List<Etudiant> etudiants) {
        this.anneeUniversitaire = anneeUniversitaire;
        this.etudiant = etudiants;
    }

    public static class ReservationBuilder {
        private LocalDate anneeUniversitaire;
        private List<Etudiant> etudiants;

        private ReservationBuilder() {
        }

        public static Reservation.ReservationBuilder create() {
            return new Reservation.ReservationBuilder();
        }

        public Reservation.ReservationBuilder anneeUniversitaire(LocalDate anneeUniversitaire) {
            this.anneeUniversitaire = anneeUniversitaire;
            return this;
        }

        public Reservation.ReservationBuilder etudiants(List<Etudiant> etudiants) {
            this.etudiants = etudiants;
            return this;
        }

        public Reservation build() {
            return new Reservation(anneeUniversitaire, etudiants);
        }
    }




}
