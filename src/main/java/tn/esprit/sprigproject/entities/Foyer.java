package tn.esprit.sprigproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "Foyer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Foyer {
    @OneToOne (mappedBy = "foyer")
    private  Universite universite;

    @OneToMany (cascade = CascadeType.ALL,mappedBy = "foyer")
    @JsonIgnore

    private List<Bloc> bloc;



    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY)
    @Column (name="idFoyer")
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;



}


