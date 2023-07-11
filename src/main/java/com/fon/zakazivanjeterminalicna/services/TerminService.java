package com.fon.zakazivanjeterminalicna.services;

import com.fon.zakazivanjeterminalicna.domain.StatusEntity;
import com.fon.zakazivanjeterminalicna.domain.Termin;
import com.fon.zakazivanjeterminalicna.repository.TerminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminService {
    @Autowired
    TerminRepo terminRepo;

    public List<Termin> getAll(){
        return terminRepo.findAll();
    }

    public Termin getByid(Long id){
        return terminRepo.findById(id).orElse(null);
    }

    public List<Termin> getByStatus(StatusEntity status){
        return terminRepo.findAllByStatus(status).orElse(null);
    }
}
