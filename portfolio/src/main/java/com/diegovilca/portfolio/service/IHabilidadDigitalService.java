package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.HabilidadDigital;
import java.util.List;

public interface IHabilidadDigitalService {
    
    public List<HabilidadDigital> getHabilidades();
    
    public void saveHabilidad(HabilidadDigital habilidad);
    
    public void deleteHabilidad(Long id);
    
    public HabilidadDigital findHabilidad(Long id);
    
    public void editHabilidad(HabilidadDigital habilidad);
    
    public void editHabilidad(Long idHabilidad, String nombre, Integer porcentaje, String tipo);
}
