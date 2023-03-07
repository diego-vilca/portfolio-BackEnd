package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.Educacion;
import com.diegovilca.portfolio.repository.IEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired
    public IEducacionRepository educacionRepo;
    
    @Override
    public List<Educacion> getEstudios() {
        return educacionRepo.findAll();
    }

    @Override
    public void saveEstudio(Educacion estudio) {
        educacionRepo.save(estudio);
    }

    @Override
    public void deleteEstudio(Long id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public Educacion findEstudio(Long id) {
        return educacionRepo.findById(id).orElse(null);
    }
    
}
