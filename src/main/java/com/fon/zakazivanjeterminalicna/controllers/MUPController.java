package com.fon.zakazivanjeterminalicna.controllers;

import com.fon.zakazivanjeterminalicna.domain.MUP;
import com.fon.zakazivanjeterminalicna.services.MupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mup")
public class MUPController {
    @Autowired
    MupService mupService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(mupService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        MUP mup = mupService.getById(id);
        if (mup!=null) return ResponseEntity.ok(mup);
        return ResponseEntity.badRequest().body("Mup sa ovim idem ne postoji");
    }

    @GetMapping("/naziv")
    public ResponseEntity<?> getByNaziv(@RequestBody String naziv){
        MUP mup = mupService.getByNaziv(naziv);
        if (mup!=null) return ResponseEntity.ok(mup);
        return ResponseEntity.badRequest().body("Mup sa ovim nazivom ne postoji");

    }

    @GetMapping("/naziv/sadrzi")
    public ResponseEntity<?> getByNazivContains(@RequestBody String nazivSub){
        List<MUP> mupovi = mupService.getByNazivContains(nazivSub);
        if (!mupovi.isEmpty()) return ResponseEntity.ok(mupovi);
        return ResponseEntity.badRequest().body("Mup sa ovim nazivom ne postoji u bazi");
    }
}
