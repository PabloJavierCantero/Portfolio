
package com.Portfolio.Cantero.security.service;

import com.Portfolio.Cantero.security.entity.Rol;
import com.Portfolio.Cantero.security.enums.RolNombre;
import com.Portfolio.Cantero.security.repository.IRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RolService {
    
    @Autowired
    IRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    
    }
    
    public void save(Rol rol){
        
        irolRepository.save(rol);    
    }  
    
}
