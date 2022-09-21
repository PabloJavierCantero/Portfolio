
package com.Portfolio.Cantero.service;

import com.Portfolio.Cantero.entity.Experience;
import com.Portfolio.Cantero.repository.RExperience;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SExperience {
    
    @Autowired
    RExperience rExperience;
    
    public List<Experience> list(){
        return rExperience.findAll();
    }
    
    public Optional<Experience> getByNombre(String nombre){
        return rExperience.findByNombre(nombre);
    }
    
    public Optional<Experience> getOne(int id){
        return rExperience.findById(id);
    }
    
    public void save(Experience experience){
        rExperience.save(experience);        
    }
    
    public void delete(int id){
        rExperience.deleteById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rExperience.existsByNombre(nombre);
    }
    
    public boolean existsById(int id){
        return rExperience.existsById(id);
    }
}
