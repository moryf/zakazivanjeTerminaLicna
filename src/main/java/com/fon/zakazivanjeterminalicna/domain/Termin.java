package com.fon.zakazivanjeterminalicna.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Reference;

import java.util.Date;

@Entity
@Table(name = "termini")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;
    private Date vreme;
    @ManyToOne
    @JoinColumn(name = "statusId")
    private StatusEntity status;
    @ManyToOne
    @JoinColumn(name = "tipDokumentaId")
    private TipDokumentaEntity tipDokumenta;
    @Reference(value = MUP.class)
    Long mupId;

    @Override
    public String toString() {
        return "Termin{" +
                "id=" + id +
                ", vreme=" + vreme +
                ", status=" + status +
                ", tipDokumenta=" + tipDokumenta +
                '}';
    }
}
