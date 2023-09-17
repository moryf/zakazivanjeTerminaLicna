package com.fon.zakazivanjeterminalicna.services;

import com.fon.zakazivanjeterminalicna.domain.*;
import com.fon.zakazivanjeterminalicna.repository.*;
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
    @Autowired
    TipDokumentaRepo tipDokumentaRepo;
    @PersistenceContext
    EntityManager entityManager;


    public List<Korisnik> getAll(){
        return korisnikRepo.findAll();
    }

    public Korisnik getById(Long id){
        return korisnikRepo.findById(id).orElse(null);
    }

    public Korisnik login(String email){
        return korisnikRepo.findByEmail(email).orElse(null);
    }
@Transactional
    public Korisnik register(Korisnik korisnik) {
        Korisnik k = korisnikRepo.findByEmail(korisnik.getEmail()).orElse(null);
        if(k==null){
            korisnikRepo.save(korisnik);
            return korisnik;
        }
        return null;
    }


@Transactional
    public void zahtevZaTermin(Long idKorisnika, Long idMupa, Termin termin, TipDokumenta tip) {
        termin.setTipDokumenta(tipDokumentaRepo.findByTipDokumenta(tip));
        termin.setStatus(statusRepo.findByStatus(Status.Zahtev));
        Korisnik korisnik = korisnikRepo.findById(idKorisnika).get();
        entityManager.persist(korisnik);
        MUP mup = mupRepo.findById(idMupa).get();
        entityManager.persist(mup);
        korisnik.getTermini().add(termin);
        mup.getTermini().add(termin);
        entityManager.persist(termin);
    }

    public List<Korisnik> getAllKorisnici(){
        return korisnikRepo.findAll();
    }
}
