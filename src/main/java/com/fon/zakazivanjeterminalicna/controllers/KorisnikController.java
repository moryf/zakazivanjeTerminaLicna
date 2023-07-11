package com.fon.zakazivanjeterminalicna.controllers;

import com.fon.zakazivanjeterminalicna.domain.Korisnik;
import com.fon.zakazivanjeterminalicna.domain.Termin;
import com.fon.zakazivanjeterminalicna.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/korisnik")
public class KorisnikController {
    @Autowired
    KorisnikService korisnikService;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String sifra){
        Korisnik korisnik = korisnikService.login(email, sifra);
        if (korisnik!=null) return ResponseEntity.ok(korisnik);
        else return ResponseEntity.badRequest().body("Pogresni parametri za login");
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(Korisnik korisnik){
        korisnikService.register(korisnik);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/zahtev/")
    public ResponseEntity<?> zahtevZaTermin(@PathVariable("id") Long idKorisnika, @RequestParam("idMupa") Long idMupa, @RequestBody Termin termin){
        korisnikService.zahtevZaTermin(idKorisnika,idMupa,termin);
        return ResponseEntity.ok().build();
    }
}
