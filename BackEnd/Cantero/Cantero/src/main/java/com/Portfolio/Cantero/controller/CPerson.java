
package com.Portfolio.Cantero.controller;

import org.apache.commons.lang3.StringUtils;
import com.Portfolio.Cantero.dto.DtoPerson;
import com.Portfolio.Cantero.entity.Person;
import com.Portfolio.Cantero.security.Mensaje;
import com.Portfolio.Cantero.service.SPerson;
import java.util.List;
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
@RequestMapping("/person")
@CrossOrigin (origins = "http://localhost:4200")
public class CPerson {
    
    @Autowired
    SPerson sPerson;
    
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list(){
        List<Person> list = sPerson.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Person> getById(@PathVariable("id") int id){
        if(!sPerson.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id del perfil no existe"), HttpStatus.BAD_REQUEST);
        }
        Person person = sPerson.getOne(id).get();
        return new ResponseEntity(person, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sPerson.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id del perfil no existe"), HttpStatus.NOT_FOUND);
        }
        sPerson.delete(id);
        return new ResponseEntity(new Mensaje("Perfil eliminado correctamente"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoPerson dtoperson){
        if(StringUtils.isBlank(dtoperson.getFullname())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sPerson.existsByFullname(dtoperson.getFullname())){
            return new ResponseEntity(new Mensaje("Este nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        Person person = new Person(dtoperson.getFullname(), dtoperson.getImgPerfil(), dtoperson.getPosicion(), dtoperson.getUbicacion(),
        dtoperson.getContacto(), dtoperson.getInteres(), dtoperson.getAcercade());
        sPerson.save(person);
        
        return new ResponseEntity(new Mensaje("Perfil creado correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable ("id") int id, @RequestBody DtoPerson dtoperson){
        if(!sPerson.existsById(id)){
            return new ResponseEntity(new Mensaje("El id del perfil no existe"), HttpStatus.NOT_FOUND);
        }     
        if(sPerson.existsByFullname(dtoperson.getFullname()) && sPerson.getByFullname(dtoperson.getFullname()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre para perfil ya existe"), HttpStatus.BAD_REQUEST);            
        }
        if(StringUtils.isBlank(dtoperson.getFullname())){
            return new ResponseEntity(new Mensaje("El campo es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Person person = sPerson.getOne(id).get();
        person.setFullname(dtoperson.getFullname());
        person.setImgPerfil(dtoperson.getImgPerfil());
        person.setPosicion(dtoperson.getPosicion());
        person.setUbicacion(dtoperson.getUbicacion());
        person.setContacto(dtoperson.getContacto());
        person.setInteres(dtoperson.getInteres());
        person.setAcercade(dtoperson.getAcercade());
        
        sPerson.save(person);
        return new ResponseEntity(new Mensaje("Perfil actualizado correctamente"), HttpStatus.OK);
    }
    
    
    
    
    
}
