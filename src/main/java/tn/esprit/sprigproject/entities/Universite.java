package tn.esprit.sprigproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "universite")
@Data

public class Universite {

    @OneToOne
    @JsonIgnore
    private Foyer foyer;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniversite")
    long idUniversite;
    String nomUniversite;
    String adress;





}
