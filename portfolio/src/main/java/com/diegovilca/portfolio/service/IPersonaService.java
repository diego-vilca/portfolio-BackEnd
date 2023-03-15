package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.Persona;
import java.util.List;

public interface IPersonaService {
    
    public List<Persona> getPersonas();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
    
    public void editPersona(Persona persona);
    
    public void editPersona(Long idPersona, String nombre,
                            String apellido, String urlBannerImg,
                            String urlPerfilImg, String acercaDe);
    
}
