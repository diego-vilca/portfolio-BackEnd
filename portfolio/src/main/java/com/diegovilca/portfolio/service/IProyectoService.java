package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    
    public List<Proyecto> getProyectos();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Long id);
    
    public Proyecto findProyecto(Long id);
}
