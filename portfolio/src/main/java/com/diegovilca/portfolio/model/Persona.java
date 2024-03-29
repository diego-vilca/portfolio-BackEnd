package com.diegovilca.portfolio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String urlBannerImg;
    private String urlPerfilImg; 
    @Column(columnDefinition= "TEXT")
    private String acercaDe;
    
    @OneToMany(mappedBy="unaPersona")
    private List<RedSocial> redes;
    
    @OneToMany(mappedBy="unaPersona")
    private List<Educacion> estudios;
    
    @OneToMany(mappedBy="unaPersona")
    private List<HabilidadDigital> habilidades;
    
    @OneToMany(mappedBy="unaPersona")
    private List<ExperienciaLaboral> trabajos;     
    
    @OneToMany(mappedBy="unaPersona")
    private List<Proyecto> proyectos;
    
    
    //CONSTRUCTOR

    public Persona() {
        this.redes = new ArrayList<>();
        this.estudios = new ArrayList<>();
        this.habilidades = new ArrayList<>();
        this.trabajos = new ArrayList<>();
        this.proyectos = new ArrayList<>();
    }

    public Persona(String nombre, String apellido, String urlBannerImg, String urlPerfilImg, String acercaDe, List<RedSocial> redes, List<Educacion> estudios, List<HabilidadDigital> habilidades, List<ExperienciaLaboral> trabajos, List<Proyecto> proyectos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.urlBannerImg = urlBannerImg;
        this.urlPerfilImg = urlPerfilImg;
        this.acercaDe = acercaDe;
        this.redes = redes;
        this.estudios = estudios;
        this.habilidades = habilidades;
        this.trabajos = trabajos;
        this.proyectos = proyectos;
    }
    
    
       
    //METODOS

    public void addExperiencia(ExperienciaLaboral experiencia){
        experiencia.setUnaPersona(this);
    }
    
    public void addEducacion(Educacion estudio){
        estudio.setUnaPersona(this);
    }
    
    public void addProyecto(Proyecto proyecto){
        proyecto.setUnaPersona(this);
    }
    
    public void addRed(RedSocial red){
        red.setUnaPersona(this);
    }
    
    public void addHabilidad(HabilidadDigital habilidad){
        habilidad.setUnaPersona(this);
    }
    
    
    
    
}
