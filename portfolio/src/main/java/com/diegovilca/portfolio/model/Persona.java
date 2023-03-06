package com.diegovilca.portfolio.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String urlBannerImg;
    private String urlPerfilImg;
    @Lob
    private String acercaDe;
    
    private List<Educacion> estudios;
    private List<ExperienciaLaboral> trabajos;
    private List<HabilidadDigital> habilidades;
    private List<Proyecto> proyectos;
    private List<RedSocial> redes;

    public Persona() {
    }
    
    
    
    
}
