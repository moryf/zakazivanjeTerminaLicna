package com.fon.zakazivanjeterminalicna.controllers;

import com.fon.zakazivanjeterminalicna.domain.*;
import com.fon.zakazivanjeterminalicna.services.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/login")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest);
        Korisnik korisnik = korisnikService.login(loginRequest.getEmail(), loginRequest.getSifra());
        if (korisnik!=null) return ResponseEntity.ok(korisnik);
        else return ResponseEntity.badRequest().body("Pogresni parametri za login");
    }
    @PostMapping("/register")
    @CrossOrigin
    public ResponseEntity<?> register(@RequestBody Korisnik korisnik){
        System.out.println(korisnik);
        Korisnik k =  korisnikService.register(korisnik);
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
}
