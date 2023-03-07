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
public class ExperienciaLaboral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idExperiencia;
    private String empresa;
    private String funcion;
    private String anioIngreso;
    private String anioEgreso;
    private String urlEmpresa;
    
    @ManyToOne
    @JoinColumn(name="idPersona")
    @JsonIgnore
    private Persona unaPersona;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long idExperiencia, String empresa, String funcion, String anioIngreso, String anioEgreso, String urlEmpresa) {
        this.idExperiencia = idExperiencia;
        this.empresa = empresa;
        this.funcion = funcion;
        this.anioIngreso = anioIngreso;
        this.anioEgreso = anioEgreso;
        this.urlEmpresa = urlEmpresa;
    }

        
}
