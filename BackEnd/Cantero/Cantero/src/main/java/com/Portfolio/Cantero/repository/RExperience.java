
package com.Portfolio.Cantero.repository;

import com.Portfolio.Cantero.entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperience extends JpaRepository<Experience, Integer> {
    
    public Optional<Experience> findByNombre(String nombre);    
    public boolean existsByNombre(String nombre);  
    
}
