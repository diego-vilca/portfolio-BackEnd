package com.diegovilca.portfolio.security.repository;

import com.diegovilca.portfolio.security.enums.RolNombre;
import com.diegovilca.portfolio.security.model.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolNombre (RolNombre rolNombre);
    
}
