package com.fon.zakazivanjeterminalicna.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mupovi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MUP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String naziv;
    String adresa;
    String brojTelefona;
    @OneToMany(cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name ="mupId")
    List<Termin> termini = new ArrayList<>();

    @Override
    public String toString() {
        return "MUP{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojTelefona='" + brojTelefona + '\'' +
                '}';
    }
}
