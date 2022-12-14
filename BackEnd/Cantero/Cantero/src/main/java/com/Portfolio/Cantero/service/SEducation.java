
package com.Portfolio.Cantero.service;

import com.Portfolio.Cantero.entity.Education;
import com.Portfolio.Cantero.repository.REducation;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEducation {
    
    @Autowired
    REducation rEducation;
    
    public List<Education> list(){
        return rEducation.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return rEducation.findById(id);    
    }
    
    public Optional <Education> getByNombre(String nombre){
        return rEducation.findByNombre(nombre);
    }
    
    public void save(Education education){
        rEducation.save(education);
    }
    
    public void delete(int id){
        rEducation.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEducation.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rEducation.existsByNombre(nombre);
    }
    
}
