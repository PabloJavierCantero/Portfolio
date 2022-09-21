
package com.Portfolio.Cantero.security.repository;

import com.Portfolio.Cantero.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByEmail(String email);
    boolean existsByNombreUsuario(String nombreUsuario);
    
}
