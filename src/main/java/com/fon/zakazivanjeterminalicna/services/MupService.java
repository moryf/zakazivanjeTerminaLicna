package com.fon.zakazivanjeterminalicna.services;

import com.fon.zakazivanjeterminalicna.domain.MUP;
import com.fon.zakazivanjeterminalicna.repository.MUPRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MupService {
    @Autowired
    MUPRepo mupRepo;

    public List<MUP> getAll(){
        return mupRepo.findAll();
    }

    public MUP getById(Long id){
        return mupRepo.findById(id).orElse(null);
    }

    public MUP getByNaziv(String naziv){
        return mupRepo.findByNaziv(naziv).orElse(null);
    }

    public List<MUP> getByNazivContains(String nazivSub){
        return mupRepo.findAllByNazivContainsIgnoreCase(nazivSub).orElse(null);
    }
}
