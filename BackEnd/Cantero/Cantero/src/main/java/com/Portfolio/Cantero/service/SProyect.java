
package com.Portfolio.Cantero.service;

import com.Portfolio.Cantero.entity.Proyect;
import com.Portfolio.Cantero.repository.RProyect;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyect {
    
    @Autowired
    RProyect rProyect;
    
    public List<Proyect> list(){
        return rProyect.findAll();
    }
    
    public Optional<Proyect> getOne(int id){
        return rProyect.findById(id);
    }
    
    public Optional<Proyect> findByNombre(String nombre){
        return rProyect.findByNombre(nombre);
    }
    
    public void save(Proyect proyect){
        rProyect.save(proyect);
    }
    
    public void delete(int id){
        rProyect.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyect.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rProyect.existsByNombre(nombre);
    }
    
}
