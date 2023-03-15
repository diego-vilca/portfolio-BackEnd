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

    @Override
    public void editEstudio(Educacion estudio) {
        educacionRepo.save(estudio);    }

    @Override
    public void editEstudio(Long idEstudio, String institucion, 
                            String titulo, String anioIngreso, 
                            String anioEgreso, String urlImg, 
                            String urlWeb, String urlCertificado) {
        
        Educacion educacion = this.findEstudio(idEstudio);
        
        if (institucion != null) {
            educacion.setInstitucion(institucion);
        }
        if(titulo != null){
            educacion.setTitulo(titulo);
        }
        if(anioIngreso != null){
            educacion.setAnioIngreso(anioIngreso);
        }
        if(anioEgreso != null){
            educacion.setAnioEgreso(anioEgreso);
        }
        if(urlImg != null){
            educacion.setUrlImg(urlImg);
        }
        if(urlWeb != null){
            educacion.setUrlWeb(urlWeb);
        }
        if(urlCertificado != null){
            educacion.setUrlCertificado(urlCertificado);
        }
        
        this.saveEstudio(educacion);
    }

    
    
}
