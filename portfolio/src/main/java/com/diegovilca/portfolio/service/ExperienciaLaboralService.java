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
    public void editTrabajo(Long idTrabajo, String empresa, String funcion, String anioIngreso, String anioEgreso, String urlEmpresa) {
        
        ExperienciaLaboral experiencia = this.findTrabajo(idTrabajo);
        
        if (empresa != null) {
            experiencia.setEmpresa(empresa);
        }
        if(funcion != null){
            experiencia.setFuncion(funcion);
        }
        if(anioIngreso != null){
            experiencia.setAnioIngreso(anioIngreso);
        }
        if(anioEgreso != null){
            experiencia.setAnioEgreso(anioEgreso);
        }
        if(urlEmpresa != null){
            experiencia.setUrlEmpresa(urlEmpresa);
        }
        
        this.saveTrabajo(experiencia);
    }

    
    
}
