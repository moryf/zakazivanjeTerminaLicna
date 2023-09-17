package com.fon.zakazivanjeterminalicna.services;

import com.fon.zakazivanjeterminalicna.domain.Status;
import com.fon.zakazivanjeterminalicna.domain.Termin;
import com.fon.zakazivanjeterminalicna.repository.StatusRepo;
import com.fon.zakazivanjeterminalicna.repository.TerminRepo;
import com.fon.zakazivanjeterminalicna.repository.TipDokumentaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminService {
    @Autowired
    TerminRepo terminRepo;
    @Autowired
    StatusRepo statusRepo;
    @Autowired
    TipDokumentaRepo tipDokumentaRepo;



    public List<Termin> getByStatus(Status status){
        return terminRepo.findAllByStatus(statusRepo.findByStatus(status)).orElse(null);
    }

    public Optional<Termin> findById(Long id) {
        return terminRepo.findById(id);
    }


    public void aktiviraj(Long id) {
        Termin termin = terminRepo.findById(id).get();
        System.out.println(termin);
        termin.setStatus(statusRepo.findByStatus(Status.Zakazan));
        terminRepo.save(termin);
    }

    public void odbij(Long id) {
        Termin termin = terminRepo.findById(id).get();
        termin.setStatus(statusRepo.findByStatus(Status.Odbijen));
        terminRepo.save(termin);
    }

    public void delete(Long id) {
        terminRepo.deleteById(id);
    }
}
