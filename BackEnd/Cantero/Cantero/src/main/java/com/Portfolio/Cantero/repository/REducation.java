
package com.Portfolio.Cantero.repository;

import com.Portfolio.Cantero.entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface REducation extends JpaRepository<Education, Integer>{
    
    public Optional<Education> findByNombre(String nombre);       
    public boolean existsByNombre(String nombre);  
    
    
}
