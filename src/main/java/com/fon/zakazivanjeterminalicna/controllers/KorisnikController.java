package com.fon.zakazivanjeterminalicna.controllers;

import com.fon.zakazivanjeterminalicna.domain.*;
import com.fon.zakazivanjeterminalicna.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
@RequestMapping("/api/korisnik")
public class KorisnikController {
    @Autowired
    KorisnikService korisnikService;

    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    KorisnikController(KorisnikService korisnikService){
        this.korisnikService = korisnikService;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest);
        String email = loginRequest.getEmail();
        String sifra = loginRequest.getSifra();
        Korisnik korisnik = korisnikService.login(email);
        if (korisnik == null) return ResponseEntity.badRequest().body("Pogresni parametri za login");
        if (bCryptPasswordEncoder.matches(sifra, korisnik.getSifra())) return ResponseEntity.ok(korisnik);
        else return ResponseEntity.badRequest().body("Pogresni parametri za login");
    }

    @GetMapping("/{id}/termini")
    @CrossOrigin
    public ResponseEntity<?> termini(@PathVariable Long id){
        System.out.println(id);
        System.out.println(korisnikService.getById(id).getTermini());
        return ResponseEntity.ok(korisnikService.getById(id).getTermini());
    }

    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<?> register(@RequestBody Korisnik korisnik){
        System.out.println(korisnik);
        korisnik.setSifra(bCryptPasswordEncoder.encode(korisnik.getSifra()));
        System.out.println(korisnik.getSifra());
        Korisnik k =  korisnikService.register(korisnik);
        if (k == null) return ResponseEntity.badRequest().body("Korisnik vec postoji");
        return ResponseEntity.ok(k);
    }

    @PostMapping("/zahtev")
    @CrossOrigin
    public ResponseEntity<?> zahtevZaTermin(@RequestBody TerminDTO terminDTO){
        System.out.println(terminDTO);
        Termin termin = new Termin();
        LocalDateTime dateTime = LocalDateTime.parse(terminDTO.getVreme(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        Date javaUtilDate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        termin.setVreme(javaUtilDate);
        korisnikService.zahtevZaTermin(terminDTO.getKorisnikId(), terminDTO.getMupId(), termin,terminDTO.getTipDokumenta());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    @CrossOrigin
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(korisnikService.getAllKorisnici());
    }

}
