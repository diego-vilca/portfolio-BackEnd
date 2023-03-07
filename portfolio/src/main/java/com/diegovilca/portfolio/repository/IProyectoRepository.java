package com.diegovilca.portfolio.repository;

import com.diegovilca.portfolio.model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
