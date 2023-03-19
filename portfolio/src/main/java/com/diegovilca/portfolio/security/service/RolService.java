package com.diegovilca.portfolio.security.service;

import com.diegovilca.portfolio.security.enums.RolNombre;
import com.diegovilca.portfolio.security.model.Rol;
import com.diegovilca.portfolio.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository rolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre)  {
        return rolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}