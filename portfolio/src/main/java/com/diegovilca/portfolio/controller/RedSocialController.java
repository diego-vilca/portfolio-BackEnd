package com.diegovilca.portfolio.controller;

import com.diegovilca.portfolio.model.Persona;
import com.diegovilca.portfolio.model.RedSocial;
import com.diegovilca.portfolio.service.IPersonaService;
import com.diegovilca.portfolio.service.IRedSocialService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("social")
@CrossOrigin("*")//(origins = {"http://localhost:4200"})
public class RedSocialController {
    
    @Autowired
    private IRedSocialService redService;
    @Autowired
    private IPersonaService personaService;
    
    //ALTA
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/create")
    public void agregarRed (@RequestBody RedSocial red){
        this.redService.saveRed(red);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/create/{idPersona}")
    public void agregarRed (@RequestBody RedSocial red, @PathVariable Long idPersona){
        Persona unaPersona = personaService.findPersona(idPersona);
        unaPersona.addRed(red);
        
        this.redService.saveRed(red);
    }
    
    //MOSTRAR
    @GetMapping ("/list")
    @ResponseBody
    public List<RedSocial> verRedes(){
        return this.redService.getRedes();
    }
    
    //BUSCAR 
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{idRed}")
    public RedSocial buscarRed(@PathVariable Long idRed){
        return redService.findRed(idRed);
    }
    
    //BAJA
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarRed (@PathVariable Long id){
        this.redService.deleteRed(id);
    }
    
    //EDITAR
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{idRed}")
    public void editarRed(@PathVariable Long idRed,
            @RequestParam( required = false, name = "iconoFA") String iconoFA,
            @RequestParam( required = false, name = "color") String color,
            @RequestParam( required = false, name = "urlRed") String urlRed){
        
        redService.editRed(idRed, iconoFA, color, urlRed);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update")
    public void editarRed( @RequestBody RedSocial redMod){
        
        this.redService.editRed(redMod);
    }
        
}
