package com.diegovilca.portfolio.controller;

import com.diegovilca.portfolio.model.ExperienciaLaboral;
import com.diegovilca.portfolio.model.Persona;
import com.diegovilca.portfolio.service.IExperienciaLaboralService;
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
@RequestMapping("job")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService experienciaService;
    @Autowired
    private IPersonaService personaService;
    
    //ALTA
    @PostMapping ("/create/")
    public void agregarExperiencia (@RequestBody ExperienciaLaboral experiencia){
        this.experienciaService.saveTrabajo(experiencia);
    }
    
    @PostMapping ("/create/{idPersona}")
    public void agregarExperiencia (@RequestBody ExperienciaLaboral experiencia, @PathVariable Long idPersona){
        Persona unaPersona = personaService.findPersona(idPersona);
        unaPersona.addExperiencia(experiencia);
        
        this.experienciaService.saveTrabajo(experiencia);
    }
    
    //MOSTRAR
    @GetMapping ("/list")
    @ResponseBody
    public List<ExperienciaLaboral> verExperiencias(){
        return this.experienciaService.getTrabajos();
    }
    
    //BUSCAR 
    @GetMapping("/{idExperiencia}")
    public ExperienciaLaboral buscarExperiencia(@PathVariable Long idExperiencia){
        return experienciaService.findTrabajo(idExperiencia);
    }
    
    //BAJA
    @DeleteMapping ("/delete/{id}")
    public void borrarExperiencia (@PathVariable Long id){
        this.experienciaService.deleteTrabajo(id);
    }
    
    //EDITAR
    @PutMapping("/update/{idExperiencia}")
    public void editarExperiencia(@PathVariable Long idExperiencia,
            @RequestParam( required = false, name = "empresa") String empresa,
            @RequestParam( required = false, name = "funcion") String funcion,
            @RequestParam( required = false, name = "anioIngreso") String anioIngreso,
            @RequestParam( required = false, name = "anioEgreso") String anioEgreso,
            @RequestParam( required = false, name = "urlEmpresa") String urlEmpresa){
        
        experienciaService.editTrabajo(idExperiencia, empresa, funcion, anioIngreso, anioEgreso, urlEmpresa);
    }
    
     @PutMapping("/update")
    public void editarExperiencia( @RequestBody ExperienciaLaboral experienciaMod){
        
        this.experienciaService.editTrabajo(experienciaMod);
    }
    
    
}
