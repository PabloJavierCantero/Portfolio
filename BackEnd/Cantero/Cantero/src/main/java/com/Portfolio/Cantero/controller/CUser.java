
package com.Portfolio.Cantero.controller;

import com.Portfolio.Cantero.entity.User;
import com.Portfolio.Cantero.service.SUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CUser {
    
    @Autowired
    private SUser sUser;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/crear")
    public void agregarUser(@RequestBody User user){
        sUser.crearUser(user);
    }
    
    @GetMapping ("/user/ver")
    @ResponseBody
    public List<User> verUser(){
     return sUser.verUser();    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/user/borrar/{id}")
    public void borrarUser(@PathVariable int id){
        sUser.borrarUser(id);    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/user/editar/{id}")
    public void editarUser(@PathVariable int id,
                              @RequestParam ("nombre") String nuevoNombre,
                              @RequestParam ("apellido") String nuevoApellido){
     
        User user = sUser.buscarUser(id);
        user.setNombre(nuevoNombre);
        user.setApellido(nuevoApellido);
        
        sUser.crearUser(user);        
    }
    
    
}
