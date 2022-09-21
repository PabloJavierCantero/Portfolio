
package com.Portfolio.Cantero.security.repository;

import com.Portfolio.Cantero.security.entity.Rol;
import com.Portfolio.Cantero.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    
    Optional<Rol> findByRolNombre(RolNombre rolNombre); 
    
}
