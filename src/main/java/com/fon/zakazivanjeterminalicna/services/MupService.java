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
        return mupRepo.getByNaziv(naziv).orElse(null);
    }

    public List<MUP> getByNazivContains(String nazivSub){
        return mupRepo.findAllByNazivContainsIgnoreCase(nazivSub).orElse(null);
    }

    public void addMup(MUP mup) {
        mupRepo.save(mup);
    }

    public MUP updateMup(MUP mup, Long id) {
        MUP mup1 = mupRepo.findById(id).get();
        mup1.setBrojTelefona(mup.getBrojTelefona());
        mup1.setNaziv(mup.getNaziv());
        mup1.setAdresa(mup.getAdresa());
        mupRepo.save(mup1);
        return mup1;
    }

    public void deleteMup(Long id) {
        mupRepo.deleteById(id);
    }
}
