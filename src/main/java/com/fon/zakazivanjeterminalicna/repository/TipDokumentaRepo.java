package com.fon.zakazivanjeterminalicna.repository;

import com.fon.zakazivanjeterminalicna.domain.TipDokumenta;
import com.fon.zakazivanjeterminalicna.domain.TipDokumentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipDokumentaRepo extends JpaRepository<TipDokumentaEntity,Long> {

    public TipDokumentaEntity findByTipDokumenta(TipDokumenta tipDokumenta);
}
