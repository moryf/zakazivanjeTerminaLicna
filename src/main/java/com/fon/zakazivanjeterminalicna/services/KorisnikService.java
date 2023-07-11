package com.fon.zakazivanjeterminalicna.services;

import com.fon.zakazivanjeterminalicna.domain.Korisnik;
import com.fon.zakazivanjeterminalicna.domain.MUP;
import com.fon.zakazivanjeterminalicna.domain.Status;
import com.fon.zakazivanjeterminalicna.domain.Termin;
import com.fon.zakazivanjeterminalicna.repository.KorisnikRepo;
import com.fon.zakazivanjeterminalicna.repository.MUPRepo;
import com.fon.zakazivanjeterminalicna.repository.StatusRepo;
import com.fon.zakazivanjeterminalicna.repository.TerminRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KorisnikService {
    @Autowired
    KorisnikRepo korisnikRepo;
    @Autowired
    MUPRepo mupRepo;
    @Autowired
    TerminRepo terminRepo;
    @Autowired
    StatusRepo statusRepo;
    @PersistenceContext
    EntityManager entityManager;


    public List<Korisnik> getAll(){
        return korisnikRepo.findAll();
    }

    public Korisnik getById(Long id){
        return korisnikRepo.findById(id).orElse(null);
    }

    public Korisnik login(String email,String sifra){
        return korisnikRepo.findByEmailAndSifra(email,sifra).orElse(null);
    }

    public void register(Korisnik korisnik) {
        korisnikRepo.save(korisnik);
    }


@Transactional
    public void zahtevZaTermin(Long idKorisnika, Long idMupa, Termin termin) {
        termin.setStatus(statusRepo.findByStatus(Status.Zahtev));
        Korisnik korisnik = korisnikRepo.findById(idKorisnika).get();
        entityManager.persist(korisnik);
        MUP mup = mupRepo.findById(idMupa).get();
        entityManager.persist(mup);
        korisnik.getTermini().add(termin);
        mup.getTermini().add(termin);
        entityManager.persist(termin);
    }
}
