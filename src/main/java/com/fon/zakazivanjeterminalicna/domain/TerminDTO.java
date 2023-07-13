package com.fon.zakazivanjeterminalicna.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TerminDTO {
    String vreme;
    Long mupId;
    Long korisnikId;
    TipDokumenta tipDokumenta;
}
