package com.fon.zakazivanjeterminalicna.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginRequest {
    String email;
    String sifra;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                '}';
    }
}
