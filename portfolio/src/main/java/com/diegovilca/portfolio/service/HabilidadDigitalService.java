package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.HabilidadDigital;
import com.diegovilca.portfolio.repository.IHabilidadDigitalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadDigitalService implements IHabilidadDigitalService{
    
    @Autowired
    public IHabilidadDigitalRepository habilidadRepo;

    @Override
    public List<HabilidadDigital> getHabilidades() {
        return habilidadRepo.findAll();
    }

    @Override
    public void saveHabilidad(HabilidadDigital habilidad) {
        habilidadRepo.save(habilidad);
    }

    @Override
    public void deleteHabilidad(Long id) {
        habilidadRepo.deleteById(id);
    }

    @Override
    public HabilidadDigital findHabilidad(Long id) {
        return habilidadRepo.findById(id).orElse(null);
    }

    @Override
    public void editHabilidad(HabilidadDigital habilidad) {
        habilidadRepo.save(habilidad);
    }

    
    @Override
    public void editHabilidad(Long idHabilidad, String nombre, Integer porcentaje, String tipo) {
        
        HabilidadDigital habilidad = this.findHabilidad(idHabilidad);
        
        if(nombre != null){
            habilidad.setNombre(nombre);
        }
        if(porcentaje != null){
            habilidad.setPorcentaje(porcentaje);
        }
        if(tipo != null){
            habilidad.setTipo(tipo);
        }
        
        this.saveHabilidad(habilidad);
        
    }
    
}
