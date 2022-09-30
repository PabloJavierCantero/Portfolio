
package com.Portfolio.Cantero.controller;

import com.Portfolio.Cantero.dto.DtoHys;
import com.Portfolio.Cantero.entity.Hys;
import com.Portfolio.Cantero.security.Mensaje;
import com.Portfolio.Cantero.service.SHys;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/hys")
public class CHys {
    
    @Autowired
    SHys sHys;
    
    @GetMapping("/list")
    public ResponseEntity<List<Hys>> list(){
        List<Hys> list = sHys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Hys> getById(@PathVariable("id") int id){
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe ID para Skill"), HttpStatus.BAD_REQUEST);
        }    
        Hys hys = sHys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){        
        if(!sHys.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID de Skill no existe"), HttpStatus.NOT_FOUND);
        }
        sHys.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminada correctamente"), HttpStatus.OK);            
    } 
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoHys dtoHys){
        if(StringUtils.isBlank(dtoHys.getNombre())){
           return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }   
        if(sHys.existsByNombre(dtoHys.getNombre())){
           return new ResponseEntity(new Mensaje("Ese nombre para Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        Hys hys = new Hys(dtoHys.getNombre(), dtoHys.getPorcentaje());
        sHys.save(hys);
        
        return new ResponseEntity(new Mensaje("Skill creada correctamente"), HttpStatus.OK);    
    }
    
    @PutMapping("/update/{id}")    
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoHys dtoHys){
        
        if(!sHys.existsById(id)){  
            return new ResponseEntity(new Mensaje("El ID de Skill no existe"), HttpStatus.NOT_FOUND);
        }    
            
        if(StringUtils.isBlank(dtoHys.getNombre())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Hys hys = sHys.getOne(id).get();
       hys.setNombre(dtoHys.getNombre());
       hys.setPorcentaje(dtoHys.getPorcentaje());
        
        
        
        sHys.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
}
