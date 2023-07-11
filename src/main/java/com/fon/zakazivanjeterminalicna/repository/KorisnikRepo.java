package com.fon.zakazivanjeterminalicna.repository;

import com.fon.zakazivanjeterminalicna.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KorisnikRepo extends JpaRepository<Korisnik,Long> {

}
