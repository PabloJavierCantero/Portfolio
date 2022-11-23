
package com.Portfolio.Cantero.controller;

import com.Portfolio.Cantero.dto.DtoExperience;
import com.Portfolio.Cantero.entity.Experience;
import com.Portfolio.Cantero.security.Mensaje;
import com.Portfolio.Cantero.service.SExperience;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "https://frontendportfolio-2ce23.web.app")
public class CExperience {
    
    @Autowired
    SExperience sExperience;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> list(){
        List<Experience> list = sExperience.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id){
        if(!sExperience.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID para experiencia"), HttpStatus.BAD_REQUEST);
        }    
        Experience experience = sExperience.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){        
        if(!sExperience.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID de experiencia no existe"), HttpStatus.NOT_FOUND);
        }
        sExperience.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada correctamente"), HttpStatus.OK);            
    } 
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperience dtoexp){
        if(StringUtils.isBlank(dtoexp.getNombre())){
           return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }   
        if(sExperience.existsByNombre(dtoexp.getNombre())){
           return new ResponseEntity(new Mensaje("Ese nombre para experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        Experience experience = new Experience(dtoexp.getNombre(), dtoexp.getDescripcion(), dtoexp.getFecha(), dtoexp.getPuesto());
        sExperience.save(experience);
        
        return new ResponseEntity(new Mensaje("Experiencia creada correctamente"), HttpStatus.OK);    
    }
    
    @PutMapping("/update/{id}")    
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperience dtoexp){
        
        if(!sExperience.existsById(id)){  
            return new ResponseEntity(new Mensaje("El ID de experiencia no existe"), HttpStatus.NOT_FOUND);
        }    
        if(sExperience.existsByNombre(dtoexp.getNombre()) && sExperience.getByNombre(dtoexp.getNombre()).get().getId() !=id){
            return new ResponseEntity(new Mensaje("Ese nombre para experiencia ya existe"), HttpStatus.BAD_REQUEST);
        }    
        if(StringUtils.isBlank(dtoexp.getNombre())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = sExperience.getOne(id).get();
        experience.setNombre(dtoexp.getNombre());
        experience.setDescripcion(dtoexp.getDescripcion());
        experience.setFecha(dtoexp.getFecha());
        experience.setPuesto(dtoexp.getPuesto());
        
        
        sExperience.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    
}
