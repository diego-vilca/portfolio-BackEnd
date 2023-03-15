package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.Persona;
import com.diegovilca.portfolio.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    public IPersonaRepository personaRepo;

    @Override
    public List<Persona> getPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepo.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        return personaRepo.findById(id).orElse(null);
    }

    @Override
    public void editPersona(Persona persona){
        personaRepo.save(persona);
    }

    @Override
    public void editPersona(Long idPersona, String nombre, 
                            String apellido, String urlBannerImg, 
                            String urlPerfilImg, String acercaDe) {
        
        Persona persona = this.findPersona(idPersona);
        
        if (nombre != null) {
            persona.setNombre(nombre);
        }
        if(apellido != null){
            persona.setApellido(apellido);
        }
        if(urlBannerImg != null){
            persona.setUrlBannerImg(urlBannerImg);
        }
        if(urlPerfilImg != null){
            persona.setUrlPerfilImg(urlPerfilImg);
        }
        if(acercaDe != null){
            persona.setAcercaDe(acercaDe);
        }
        
        this.savePersona(persona);
        
    }
    
    
    
}
