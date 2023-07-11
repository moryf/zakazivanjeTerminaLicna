package com.fon.zakazivanjeterminalicna;

import com.fon.zakazivanjeterminalicna.domain.Korisnik;
import com.fon.zakazivanjeterminalicna.domain.MUP;
import com.fon.zakazivanjeterminalicna.domain.Termin;
import com.fon.zakazivanjeterminalicna.repository.KorisnikRepo;
import com.fon.zakazivanjeterminalicna.repository.MUPRepo;
import com.fon.zakazivanjeterminalicna.repository.TerminRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class ZakazivanjeTerminaLicnaApplication implements CommandLineRunner{

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    TerminRepo terminRepo;
    @Autowired
    KorisnikRepo korisnikRepo;

    @Autowired
    MUPRepo mupRepo;



    public static void main(String[] args) {
        SpringApplication.run(ZakazivanjeTerminaLicnaApplication.class, args);
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        terminRepo.deleteAll();
        korisnikRepo.deleteAll();
        mupRepo.deleteAll();
        MUP mup = new MUP();
        mup.setAdresa("Adresa");
        mup.setNaziv("Mup");
        mup.setEmail("email");
        mup.setBrojTelefona("0123456789");

        Korisnik korisnik = new Korisnik();
        korisnik.setMup(mup);
        korisnik.setIme("ime");
        korisnik.setPrezime("prezime");
        korisnik.setAdmin(false);
        korisnik.setSifra("sifra");
        korisnik.setEmail("email");
        korisnik.setAdresa("adresa");

        Termin termin = new Termin();
        termin.setVreme(new Date());

        korisnik.getTermini().add(termin);
        mup.getTermini().add(termin);

        entityManager.persist(korisnik);
        entityManager.persist(mup);

        Termin novitermin=terminRepo.findById(termin.getId()).orElse(null);
        System.out.println(novitermin);
        Korisnik korisnik1=korisnikRepo.findById(korisnik.getId()).orElse(null);
        System.out.println(korisnik1);
        System.out.println(korisnik1.getTermini().get(0));
    }
}
