package com.diegovilca.portfolio.repository;

import com.diegovilca.portfolio.model.RedSocial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRedesRepository extends JpaRepository<RedSocial, Long>{
    
}
