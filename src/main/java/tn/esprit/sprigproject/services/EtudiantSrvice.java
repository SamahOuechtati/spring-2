package tn.esprit.sprigproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.sprigproject.entities.Etudiant;
import tn.esprit.sprigproject.entities.Universite;
import tn.esprit.sprigproject.repositories.EtudiantRepository;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EtudiantSrvice implements IEtudiantService {



    EtudiantRepository etu;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etu.findAll();
    }

    @Override
    public List<Etudiant> addEtudiants(Etudiant e ) {
        etu.save(e);
        return etu.findAll();
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etu.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
        return etu.findById(idEtudiant).orElse(null);
    }



    @Override
    public void removeEtudiant(long idEtudiant) {
        etu.deleteById(idEtudiant);

    }




}
