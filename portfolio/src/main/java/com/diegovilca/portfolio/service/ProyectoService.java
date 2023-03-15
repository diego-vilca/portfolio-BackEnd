package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.Proyecto;
import com.diegovilca.portfolio.repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
    
    @Autowired
    public IProyectoRepository proyectoRepo;

    @Override
    public List<Proyecto> getProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        return proyectoRepo.findById(id).orElse(null);
    }

    @Override
    public void editProyecto(Proyecto proyecto) {
        proyectoRepo.save(proyecto);
    }

    @Override
    public void editProyecto(Long idProyecto, String nombre, String descripcion, String urlImg, String urlVideo, String urlRepositorio) {
        
        Proyecto proyecto = this.findProyecto(idProyecto);
        
        if (nombre != null) {
            proyecto.setNombre(nombre);
        }
        if(descripcion != null){
            proyecto.setDescripcion(descripcion);
        }
        if(urlImg != null){
            proyecto.setUrlImg(urlImg);
        }
        if(urlVideo != null){
            proyecto.setUrlVideo(urlVideo);
        }
        if(urlRepositorio != null){
            proyecto.setUrlRepositorio(urlRepositorio);
        }
        
        this.saveProyecto(proyecto);
    }

    
    
}
