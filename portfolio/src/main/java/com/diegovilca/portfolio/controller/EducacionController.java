package com.diegovilca.portfolio.controller;

import com.diegovilca.portfolio.model.Educacion;
import com.diegovilca.portfolio.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("education")
public class EducacionController {
    
    @Autowired
    private IEducacionService educacionService;
    
    //ALTA
    @PostMapping ("/create")
    public void agregarEducacion (@RequestBody Educacion estudio){
        this.educacionService.saveEstudio(estudio);
    }
    
    //MOSTRAR
    @GetMapping ("/list")
    @ResponseBody
    public List<Educacion> verEducacion(){
        return this.educacionService.getEstudios();
    }
    
    //BAJA
    @DeleteMapping ("/delete/{id}")
    public void borrarEducacion (@PathVariable Long id){
        this.educacionService.deleteEstudio(id);
    }
    
    //EDITAR
    @PutMapping("/update/{idEstudio}")
    public void editarEducacion(@PathVariable Long idEstudio,
            @RequestParam( required = false, name = "institucion") String institucion,
            @RequestParam( required = false, name = "titulo") String titulo,
            @RequestParam( required = false, name = "anioIngreso") String anioIngreso,
            @RequestParam( required = false, name = "anioEgreso") String anioEgreso,
            @RequestParam( required = false, name = "urlImg") String urlImg,
            @RequestParam( required = false, name = "urlWeb") String urlWeb,
            @RequestParam( required = false, name = "urlCertificado") String urlCertificado){
        
        educacionService.editEstudio(idEstudio, institucion, titulo, anioIngreso, anioEgreso, urlImg, urlWeb, urlCertificado);
    }
    
     @PutMapping("/update")
    public void editarEducacion( @RequestBody Educacion estudioMod){
        
        this.educacionService.editEstudio(estudioMod);
    }
}
