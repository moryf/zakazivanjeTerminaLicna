package com.fon.zakazivanjeterminalicna.controllers;

import com.fon.zakazivanjeterminalicna.domain.MUP;
import com.fon.zakazivanjeterminalicna.services.MupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/mup")
public class MUPController {
    @Autowired
    MupService mupService;
    @CrossOrigin
    @GetMapping()
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(mupService.getAll());
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        System.out.println(id);
        MUP mup = mupService.getById(id);
        if (mup!=null) return ResponseEntity.ok(mup);
        return ResponseEntity.badRequest().body("Mup sa ovim idem ne postoji");
    }
    @CrossOrigin
    @GetMapping("/naziv")
    public ResponseEntity<?> getByNaziv(@RequestParam("naziv") String naziv){
        MUP mup = mupService.getByNaziv(naziv);
        if (mup!=null) return ResponseEntity.ok(mup);
        return ResponseEntity.badRequest().body("Mup sa ovim nazivom ne postoji");

    }
    @CrossOrigin
    @GetMapping("/naziv/sadrzi")
    public ResponseEntity<?> getByNazivContains(@RequestParam("naziv") String nazivSub){
        List<MUP> mupovi = mupService.getByNazivContains(nazivSub);
        if (!mupovi.isEmpty()) return ResponseEntity.ok(mupovi);
        return ResponseEntity.badRequest().body("Mup sa ovim nazivom ne postoji u bazi");
    }
    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<?> addMup(@RequestBody MUP mup){
        mupService.addMup(mup);
        return ResponseEntity.ok().build();
    }
    @CrossOrigin
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateMup(@RequestBody MUP mup,@PathVariable("id") Long id){
        MUP mup1 = mupService.updateMup(mup, id);
        if (mup1!=null) return ResponseEntity.ok(mup1);
        return ResponseEntity.badRequest().body("Mup sa ovim idem ne postoji");
    }

}
