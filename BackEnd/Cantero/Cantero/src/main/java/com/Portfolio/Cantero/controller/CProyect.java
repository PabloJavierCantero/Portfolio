
package com.Portfolio.Cantero.controller;

import com.Portfolio.Cantero.dto.DtoProyect;
import com.Portfolio.Cantero.entity.Proyect;
import com.Portfolio.Cantero.security.Mensaje;
import com.Portfolio.Cantero.service.SProyect;
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
@RequestMapping("/proyect")
@CrossOrigin (origins = "http://localhost:4200")
public class CProyect {
    
    @Autowired
    SProyect sProyect;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyect>> list(){
        List<Proyect> list = sProyect.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyect> getById(@PathVariable int id){
        if(!sProyect.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID del proyecto no existe"), HttpStatus.BAD_REQUEST);
        }
        Proyect proyect = sProyect.getOne(id).get();
        return new ResponseEntity(proyect, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sProyect.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID del proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        sProyect.delete(id);
        return new ResponseEntity(new Mensaje("El proyecto ha sido eliminado correctamente"), HttpStatus.OK);
    }
    
     @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyect dtoproyect){
        if(StringUtils.isBlank(dtoproyect.getNombre())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sProyect.existsByNombre(dtoproyect.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre de proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        Proyect proyect = new Proyect(dtoproyect.getNombre(), dtoproyect.getDescripcion(), dtoproyect.getFecha(), dtoproyect.getLink());
        sProyect.save(proyect);
        return new ResponseEntity(new Mensaje("El proyecto fue creado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyect dtoproyect){
        if(!sProyect.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID del proyecto no existe"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(dtoproyect.getNombre())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }        
        
        Proyect proyect = sProyect.getOne(id).get();
        proyect.setNombre(dtoproyect.getNombre());
        proyect.setDescripcion(dtoproyect.getDescripcion());
        proyect.setFecha(dtoproyect.getFecha());
        proyect.setLink(dtoproyect.getLink());
        
        sProyect.save(proyect);
        return new ResponseEntity(new Mensaje("Proyecto actualizado correctamente"), HttpStatus.OK);
    }
    
}
