package com.diegovilca.portfolio.security.Dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class LoginUsuario {
    @NotNull
    private String nombreUsuario;
    @NotNull
    private String password;
}
