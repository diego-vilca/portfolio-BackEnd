package com.diegovilca.portfolio.controller;

import com.diegovilca.portfolio.model.HabilidadDigital;
import com.diegovilca.portfolio.model.Persona;
import com.diegovilca.portfolio.service.IHabilidadDigitalService;
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
@RequestMapping("skill")
@CrossOrigin(origins = {"http://localhost:4200"})
public class HabilidadDigitalController {
    
    
    @Autowired
    private IHabilidadDigitalService habilidadService;
    @Autowired
    private IPersonaService personaService;
    
    //ALTA
    @PostMapping ("/create")
    public void agregarHabilidad (@RequestBody HabilidadDigital habilidad){
        this.habilidadService.saveHabilidad(habilidad);
    }
    
    @PostMapping ("/create/{idPersona}")
    public void agregarHabilidad (@RequestBody HabilidadDigital habilidad, @PathVariable Long idPersona){
        Persona unaPersona = personaService.findPersona(idPersona);
        unaPersona.addHabilidad(habilidad);
        
        this.habilidadService.saveHabilidad(habilidad);
    }
    
    //MOSTRAR
    @GetMapping ("/list")
    @ResponseBody
    public List<HabilidadDigital> verHabilidades(){
        return this.habilidadService.getHabilidades();
    }
    
    //BUSCAR 
    @GetMapping("/{idHabilidad}")
    public HabilidadDigital buscarHabilidad(@PathVariable Long idHabilidad){
        return habilidadService.findHabilidad(idHabilidad);
    }
    
    //BAJA
    @DeleteMapping ("/delete/{id}")
    public void borrarHabilidad (@PathVariable Long id){
        this.habilidadService.deleteHabilidad(id);
    }
    
    //EDITAR
    @PutMapping("/update/{idHabilidad}")
    public void editarHabilidad(@PathVariable Long idHabilidad,
            @RequestParam( required = false, name = "nombre") String nombre,
            @RequestParam( required = false, name = "porcentaje") Integer porcentaje,
            @RequestParam( required = false, name = "tipo") String tipo){
        
        this.habilidadService.editHabilidad(idHabilidad, nombre, porcentaje, tipo);
    }
    
     @PutMapping("/update")
    public void editarHabilidad( @RequestBody HabilidadDigital habilidadMod){
        
        this.habilidadService.editHabilidad(habilidadMod);
    }
    
    
}
