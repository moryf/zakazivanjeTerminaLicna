package com.fon.zakazivanjeterminalicna.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Reference;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "korisnici")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ime;
    String prezime;
    String email;
    String sifra;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "mupId")
    MUP mup;
    String adresa;
    boolean admin;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikId")
    List<Termin> termini = new ArrayList<>();

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", mup=" + mup +
                ", adresa='" + adresa + '\'' +
                ", admin=" + admin +
                ", termini=" + termini +
                '}';
    }
}
