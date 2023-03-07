package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    
    public List<Educacion> getEstudios();
    
    public void saveEstudio(Educacion estudio);
    
    public void deleteEstudio(Long id);
    
    public Educacion findEstudio(Long id);
}
