package com.diegovilca.portfolio.service;

import com.diegovilca.portfolio.model.RedSocial;
import com.diegovilca.portfolio.repository.IRedesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedSocialService implements IRedSocialService{
    
    @Autowired
    public IRedesRepository redesRepo;
    
    @Override
    public List<RedSocial> getRedes() {
        return redesRepo.findAll();
    }

    @Override
    public void saveRed(RedSocial red) {
        redesRepo.save(red);
    }
    
   
    @Override
    public void deleteRed(Long id) {
        redesRepo.deleteById(id);
    }

    @Override
    public RedSocial findRed(Long id) {
        return redesRepo.findById(id).orElse(null);
    }

    @Override
    public void editRed(RedSocial red) {
        redesRepo.save(red);
    }

    @Override
    public void editRed(Long idRed, String iconoFA, String color, String urlRed) {
        
        RedSocial red = this.findRed(idRed);
        
        if (iconoFA != null) {
            red.setIconoFA(iconoFA);
        }
        if(color != null){
            red.setColor(color);
        }
        if(urlRed != null){
            red.setUrlRed(urlRed);
        }
        
        this.saveRed(red);
    }

    
    
}
