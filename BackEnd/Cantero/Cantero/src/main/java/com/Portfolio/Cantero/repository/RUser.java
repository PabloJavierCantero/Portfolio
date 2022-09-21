
package com.Portfolio.Cantero.repository;

import com.Portfolio.Cantero.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RUser extends JpaRepository<User, Integer> {      
    
}
