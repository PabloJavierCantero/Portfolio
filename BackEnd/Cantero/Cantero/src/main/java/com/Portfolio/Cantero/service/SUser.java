
package com.Portfolio.Cantero.service;

import com.Portfolio.Cantero.entity.User;
import com.Portfolio.Cantero.repository.RUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SUser implements IUser{     
    
    @Autowired
    RUser rUser;
    
    @Override
    public List<User> verUser() {
        return rUser.findAll();
    }
    
    @Override
    public void crearUser(User user) {
        rUser.save(user);
    }
    
    @Override
    public void borrarUser(int id) {
        rUser.deleteById(id);
    }
    
    @Override
    public User buscarUser(int id) {
        return rUser.findById(id).orElse(null);
    }
    
    @Override
    public void editarUser(User user) {
        rUser.save(user);
    }

    
    
    }
    
    
    

