package com.diegovilca.portfolio.repository;

import com.diegovilca.portfolio.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long>{
    
}
