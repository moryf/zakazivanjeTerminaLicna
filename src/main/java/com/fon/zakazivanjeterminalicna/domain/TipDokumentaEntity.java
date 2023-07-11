package com.fon.zakazivanjeterminalicna.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipoviDokumenata")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipDokumentaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    TipDokumenta tipDokumenta;
}
