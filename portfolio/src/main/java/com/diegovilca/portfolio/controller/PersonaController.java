package com.diegovilca.portfolio.controller;

import com.diegovilca.portfolio.model.Persona;
import com.diegovilca.portfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PersonaController {
    
    @Autowired
    private IPersonaService personaService;
    
    //ALTA
    @PostMapping ("/create")
    public void agregarPersona (@RequestBody Persona persona){
        this.personaService.savePersona(persona);
    }
    
    //MOSTRAR
    @GetMapping ("/list")
    @ResponseBody
    public List<Persona> verPersonas(){
        return this.personaService.getPersonas();
    }
    
    //BUSCAR 
    @GetMapping("/{idPersona}")
    public Persona buscarPersona(@PathVariable Long idPersona){
        return personaService.findPersona(idPersona);
    }
    
    //BAJA
    @DeleteMapping ("/delete/{id}")
    public void borrarPersona (@PathVariable Long id){
        this.personaService.deletePersona(id);
    }
    
    //EDITAR
    @PutMapping("/update/{idPersona}")
    public void editarPersona(@PathVariable Long idPersona,
            @RequestParam( required = false, name = "nombre") String nombre,
            @RequestParam( required = false, name = "apellido") String apellido,
            @RequestParam( required = false, name = "urlBannerImg") String urlBannerImg,
            @RequestParam( required = false, name = "urlPerfilImg") String urlPerfilImg,
            @RequestParam( required = false, name = "acercaDe") String acercaDe){
        
        personaService.editPersona(idPersona, nombre, apellido, urlBannerImg, urlPerfilImg, acercaDe);
    }
    
     @PutMapping("/update")
    public void editarPersona( @RequestBody Persona personaMod){
        
        this.personaService.editPersona(personaMod);
    }
}
