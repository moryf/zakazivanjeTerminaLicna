package com.fon.zakazivanjeterminalicna.services;

import com.fon.zakazivanjeterminalicna.domain.Korisnik;
import com.fon.zakazivanjeterminalicna.repository.KorisnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KorisnikService {
    @Autowired
    KorisnikRepo korisnikRepo;


    public List<Korisnik> getAll(){
        return korisnikRepo.findAll();
    }

    public Korisnik getById(Long id){
        return korisnikRepo.findById(id).orElse(null);
    }

    public Korisnik getByEmailAndSifra(String email,String sifra){
        return korisnikRepo.getByEmailAndSifra(email,sifra).orElse(null);
    }

}
