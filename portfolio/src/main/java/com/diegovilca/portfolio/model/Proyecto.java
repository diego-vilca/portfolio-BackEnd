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
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProyecto;
    private String nombre;
    private String descripcion;
    private String urlImg;
    private String urlVideo;
    private String urlRepositorio;
    
    @ManyToOne
    @JoinColumn(name="idPersona")
    @JsonIgnore
    private Persona unaPersona;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String urlImg, String urlVideo, String urlRepositorio) {
        //this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.urlVideo = urlVideo;
        this.urlRepositorio = urlRepositorio;
    }

    
    
}
