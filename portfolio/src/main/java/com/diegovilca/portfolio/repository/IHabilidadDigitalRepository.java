package com.diegovilca.portfolio.repository;

import com.diegovilca.portfolio.model.HabilidadDigital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadDigitalRepository extends JpaRepository< HabilidadDigital, Long>{
    
}
