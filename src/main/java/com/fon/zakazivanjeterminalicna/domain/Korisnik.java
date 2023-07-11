package com.fon.zakazivanjeterminalicna.domain;

import jakarta.persistence.*;
import lombok.*;
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
    @Column(nullable = false)
    String ime;
    @Column(nullable = false)
    String prezime;
    @Column(unique = true,nullable = false)
    String email;
    @Column(nullable = false)
    String sifra;
    String adresa;
    boolean admin=false;
    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "korisnikId")
    List<Termin> termini = new ArrayList<>();
    @Reference(value = MUP.class)
    Long mupId;

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", adresa='" + adresa + '\'' +
                ", admin=" + admin +
                ", termini=" + termini +
                '}';
    }
}
