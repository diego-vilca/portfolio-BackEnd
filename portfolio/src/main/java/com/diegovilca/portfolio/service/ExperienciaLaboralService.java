package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.ExperienciaLaboral;
import com.diegovilca.portfolio.repository.IExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService{
    
    @Autowired
    public IExperienciaLaboralRepository experienciaRepo;

    @Override
    public List<ExperienciaLaboral> getTrabajos() {
        return experienciaRepo.findAll();
    }

    @Override
    public void saveTrabajo(ExperienciaLaboral trabajo) {
        experienciaRepo.save(trabajo);
    }

    @Override
    public void deleteTrabajo(Long id) {
        experienciaRepo.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findTrabajo(Long id) {
        return experienciaRepo.findById(id).orElse(null);
    }

    @Override
    public void editTrabajo(ExperienciaLaboral trabajo) {
        experienciaRepo.save(trabajo);
    }

    @Override
    public void editTrabajo(Long idTrabajo, ExperienciaLaboral trabajoMod) {
        //trabajo original
        ExperienciaLaboral trabajoOriginal = this.findTrabajo(idTrabajo);
        //trabajo con modificaciones
        trabajoOriginal = trabajoMod;
        
        
        //guardo el trabajo modificado
        this.saveTrabajo(trabajoOriginal);
    }
    
}
