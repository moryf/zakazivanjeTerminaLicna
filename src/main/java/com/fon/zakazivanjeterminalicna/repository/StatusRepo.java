package com.fon.zakazivanjeterminalicna.repository;

import com.fon.zakazivanjeterminalicna.domain.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<StatusEntity,Long> {
}
