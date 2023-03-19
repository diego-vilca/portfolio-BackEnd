package com.diegovilca.portfolio.security.repository;

import com.diegovilca.portfolio.security.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);
}