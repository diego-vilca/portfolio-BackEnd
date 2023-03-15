package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.ExperienciaLaboral;
import java.util.List;

public interface IExperienciaLaboralService {
    
    public List<ExperienciaLaboral> getTrabajos();
    
    public void saveTrabajo(ExperienciaLaboral trabajo);
    
    public void deleteTrabajo(Long id);
    
    public ExperienciaLaboral findTrabajo(Long id);
    
    public void editTrabajo(ExperienciaLaboral trabajo);
    
    public void editTrabajo(Long idTrabajo, ExperienciaLaboral trabajoMod);

}