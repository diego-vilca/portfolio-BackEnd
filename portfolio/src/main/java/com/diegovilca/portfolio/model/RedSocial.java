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
public class RedSocial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRed;
    private String iconoFA;
    private String color;
    private String urlRed;
    @ManyToOne
    @JoinColumn(name="idPersona")  
    @JsonIgnore//evita recursividad
    private Persona unaPersona;

    public RedSocial() {
    }

    public RedSocial(String iconoFA, String color, String urlRed) {
        this.iconoFA = iconoFA;
        this.color = color;
        this.urlRed = urlRed;
    }

      

    
}
