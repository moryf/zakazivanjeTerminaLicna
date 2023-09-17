package com.fon.zakazivanjeterminalicna.repository;

import com.fon.zakazivanjeterminalicna.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KorisnikRepo extends JpaRepository<Korisnik,Long> {
public Optional<Korisnik> findByEmailAndSifra(String email,String sifra);

    public Optional<Korisnik> findByEmail(String email);

}
