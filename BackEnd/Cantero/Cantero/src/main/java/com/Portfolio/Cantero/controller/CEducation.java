
package com.Portfolio.Cantero.controller;

import com.Portfolio.Cantero.dto.DtoEducation;
import com.Portfolio.Cantero.entity.Education;
import com.Portfolio.Cantero.security.Mensaje;
import com.Portfolio.Cantero.service.SEducation;
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
@RequestMapping("/education")
@CrossOrigin (origins = "https://frontendportfolio-2ce23.web.app")
public class CEducation {
    
    @Autowired
    SEducation sEducation;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> list(){
        List<Education> list = sEducation.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID educacion"), HttpStatus.BAD_REQUEST);            
        }
        Education education = sEducation.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    } 
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID de educacion"), HttpStatus.NOT_FOUND);
        }
        sEducation.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducation dtoeducation){
        if(StringUtils.isBlank(dtoeducation.getNombre())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEducation.existsByNombre(dtoeducation.getNombre())){
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(dtoeducation.getNombre(), dtoeducation.getDescripcion(), dtoeducation.getFecha(), dtoeducation.getTitulo());
        sEducation.save(education);
        
        return new ResponseEntity(new Mensaje("Educacion creada correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducation dtoeducation){
        if(!sEducation.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID de educacion"), HttpStatus.NOT_FOUND);
        }
        if(sEducation.existsByNombre(dtoeducation.getNombre()) && sEducation.getByNombre(dtoeducation.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre para educacion ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducation.getNombre())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Education education = sEducation.getOne(id).get();
        education.setNombre(dtoeducation.getNombre());
        education.setDescripcion(dtoeducation.getDescripcion());
        education.setFecha(dtoeducation.getFecha());
        education.setTitulo(dtoeducation.getTitulo());
        
        sEducation.save(education);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
