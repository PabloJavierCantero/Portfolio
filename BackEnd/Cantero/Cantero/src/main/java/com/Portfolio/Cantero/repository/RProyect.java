
package com.Portfolio.Cantero.repository;

import com.Portfolio.Cantero.entity.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyect extends JpaRepository<Proyect, Integer>{
    
    public Optional<Proyect> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
    
}
