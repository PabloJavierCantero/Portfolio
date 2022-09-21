
package com.Portfolio.Cantero.service;

import com.Portfolio.Cantero.entity.User;
import java.util.List;



public interface IUser {
    
    public List<User> verUser();
    public void crearUser(User user);
    public void borrarUser(int id);
    public User buscarUser(int id);
    public void editarUser(User user);
}
