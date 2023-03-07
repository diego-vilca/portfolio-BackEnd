package com.diegovilca.portfolio.controller;

import com.diegovilca.portfolio.model.Persona;
import com.diegovilca.portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    @PostMapping ("/new/persona")
    public void agregarPersona (@RequestBody Persona persona){
        personaService.savePersona(persona);
    }
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
        return personaService.getPersonas();
    }
    
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        personaService.deletePersona(id);
    }
}
