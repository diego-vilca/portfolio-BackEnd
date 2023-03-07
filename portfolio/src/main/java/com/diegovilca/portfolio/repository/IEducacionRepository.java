package com.diegovilca.portfolio.repository;

import com.diegovilca.portfolio.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository< Educacion, Long>{
    
}
