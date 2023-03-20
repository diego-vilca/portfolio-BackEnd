package com.diegovilca.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class HabilidadDigital implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHabilidad;
    private String nombre;
    private Integer porcentaje;
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name="idPersona")
    @JsonIgnore//evita recursividad
    private Persona unaPersona;

    public HabilidadDigital() {
    }

    public HabilidadDigital(String nombre, Integer porcentaje, String tipo) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.tipo = tipo;
    }

    

}
