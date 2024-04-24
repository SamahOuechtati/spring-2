package tn.esprit.sprigproject.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "chambre")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre  {

    @ManyToOne
    @JsonIgnore
    private Bloc bloc ;
    @OneToMany( cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations;


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "idChambre")
    Long idChambre;
    Long numeroChambre;

    @Enumerated
    TypeChambre typeC;




}
