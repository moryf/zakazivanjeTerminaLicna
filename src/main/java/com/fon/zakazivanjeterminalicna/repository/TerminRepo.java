package com.fon.zakazivanjeterminalicna.repository;

import com.fon.zakazivanjeterminalicna.domain.StatusEntity;
import com.fon.zakazivanjeterminalicna.domain.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TerminRepo extends JpaRepository<Termin,Long> {
    public List<Termin> findAllByStatus(StatusEntity status);
}
