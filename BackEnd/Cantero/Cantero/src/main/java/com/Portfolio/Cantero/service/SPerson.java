
package com.Portfolio.Cantero.service;

import com.Portfolio.Cantero.entity.Person;
import com.Portfolio.Cantero.repository.RPerson;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SPerson {
    
    @Autowired
    RPerson rPerson;
    
    public List<Person> list(){
        return rPerson.findAll();
    }
    
    public Optional<Person> getOne(int id){
        return rPerson.findById(id);
    }
    
    public Optional<Person> getByFullname(String fullname){
        return rPerson.findByFullname(fullname);
    }
    
    public void save(Person person){
        rPerson.save(person);
    }
    
    public void delete(int id){
        rPerson.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rPerson.existsById(id);
    }
    
    public boolean existsByFullname(String fullname){
        return rPerson.existsByFullname(fullname);
    }
    
}
