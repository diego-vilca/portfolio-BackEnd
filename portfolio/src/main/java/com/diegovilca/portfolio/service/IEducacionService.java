package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    
    public List<Educacion> getEstudios();
    
    public void saveEstudio(Educacion estudio);
    
    public void deleteEstudio(Long id);
    
    public Educacion findEstudio(Long id);
    
    public void editEstudio(Educacion estudio);
    
    public void editEstudio(Long idEstudio, String institucion, 
                            String titulo, String anioIngreso, 
                            String anioEgreso, String urlImg, 
                            String urlWeb, String urlCertificado);
}
