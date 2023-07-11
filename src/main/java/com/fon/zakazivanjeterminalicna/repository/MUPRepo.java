package com.fon.zakazivanjeterminalicna.repository;

import com.fon.zakazivanjeterminalicna.domain.MUP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MUPRepo extends JpaRepository<MUP,Long> {

    public Optional<MUP> getByNaziv(String naziv);
    public Optional<List<MUP>> findAllByNazivContainsIgnoreCase(String nazivSub);

}
