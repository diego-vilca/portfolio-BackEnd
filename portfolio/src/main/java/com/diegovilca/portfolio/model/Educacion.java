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
public class Educacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idEducacion;
    private String institucion;
    private String titulo;
    private String anioIngreso;
    private String anioEgreso;
    private String urlImg;
    private String urlWeb;
    private String urlCertificado;
    
    @ManyToOne
    @JoinColumn(name="idPersona")
    @JsonIgnore//evita recursividad
    private Persona unaPersona;

    public Educacion() {
    }

    public Educacion(String institucion, String titulo, String anioIngreso, String anioEgreso, String urlImg, String urlWeb, String urlCertificado) {
        this.institucion = institucion;
        this.titulo = titulo;
        this.anioIngreso = anioIngreso;
        this.anioEgreso = anioEgreso;
        this.urlImg = urlImg;
        this.urlWeb = urlWeb;
        this.urlCertificado = urlCertificado;
    }

   
    
               
}
