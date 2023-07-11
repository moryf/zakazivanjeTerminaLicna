package com.fon.zakazivanjeterminalicna.controllers;

import com.fon.zakazivanjeterminalicna.domain.Status;
import com.fon.zakazivanjeterminalicna.domain.Termin;
import com.fon.zakazivanjeterminalicna.services.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/termin")
public class TerminController {
    @Autowired
    TerminService terminService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        Optional<Termin> termin = terminService.findById(id);
        if (termin.isPresent()) return ResponseEntity.ok(termin.get());
        else return ResponseEntity.badRequest().body("Termin sa ovim idem ne postoji");
    }

    @PutMapping("/{id}/zakazi")
    public ResponseEntity<?> aktiviraj(@PathVariable("id") Long id ){
        terminService.aktiviraj(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/odbij")
    public ResponseEntity<?> odbij(@PathVariable("id") Long id ){
        terminService.odbij(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/status")
    public ResponseEntity<?> getByStatus(@RequestParam("status")Status status){
        List<Termin> optionalLista = terminService.getByStatus(status);
        return ResponseEntity.ok(optionalLista);
    }


}
