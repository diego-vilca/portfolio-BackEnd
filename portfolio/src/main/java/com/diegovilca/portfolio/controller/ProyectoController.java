package com.diegovilca.portfolio.controller;

import com.diegovilca.portfolio.model.Proyecto;
import com.diegovilca.portfolio.service.IProyectoService;
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
@RequestMapping("project")
public class ProyectoController {
    
    @Autowired
    private IProyectoService proyectoService;
    
    //ALTA
    @PostMapping ("/create")
    public void agregarProyecto (@RequestBody Proyecto proyecto){
        this.proyectoService.saveProyecto(proyecto);
    }
    
    //MOSTRAR
    @GetMapping ("/list")
    @ResponseBody
    public List<Proyecto> verProyectos(){
        return this.proyectoService.getProyectos();
    }
    
    //BAJA
    @DeleteMapping ("/delete/{id}")
    public void borrarProyecto (@PathVariable Long id){
        this.proyectoService.deleteProyecto(id);
    }
    
    //EDITAR
    @PutMapping("/update/{idProyecto}")
    public void editarProyecto(@PathVariable Long idProyecto,
            @RequestParam( required = false, name = "nombre") String nombre,
            @RequestParam( required = false, name = "descripcion") String descripcion,
            @RequestParam( required = false, name = "urlImg") String urlImg,
            @RequestParam( required = false, name = "urlVideo") String urlVideo,
            @RequestParam( required = false, name = "urlRepositorio") String urlRepositorio){
        
        proyectoService.editProyecto(idProyecto, nombre, descripcion, urlImg, urlVideo, urlRepositorio);
    }
    
     @PutMapping("/update")
    public void editarProyecto( @RequestBody Proyecto proyectoMod){
        
        this.proyectoService.editProyecto(proyectoMod);
    }
}
