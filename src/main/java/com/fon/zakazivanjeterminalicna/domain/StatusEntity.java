package com.fon.zakazivanjeterminalicna.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "statusi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    Status status;
}
