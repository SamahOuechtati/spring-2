package tn.esprit.sprigproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table (name = "bloc")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bloc {

    @OneToMany (mappedBy = "bloc")
    @JsonIgnore
    private List<Chambre> chambre ;
    @ManyToOne (cascade = CascadeType.ALL)
    private  Foyer foyer;


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="idBloc")
    Long idBloc;
    String nomBloc;
    long capaciteBloc;


}
