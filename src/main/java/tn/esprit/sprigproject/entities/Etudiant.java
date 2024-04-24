package tn.esprit.sprigproject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table (name = "etudiant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {


    @ManyToMany (mappedBy = "etudiant")
    private List <Reservation> resrvation;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column( name = "idEtudiant")
    long idEtudiant;
    String nom;

    String prenom;
    long cin;
    String ecole;
    Date datenaissance;








}
