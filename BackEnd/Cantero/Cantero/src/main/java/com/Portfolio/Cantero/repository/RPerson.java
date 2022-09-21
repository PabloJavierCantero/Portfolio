
package com.Portfolio.Cantero.repository;

import com.Portfolio.Cantero.entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPerson extends JpaRepository<Person, Integer> {
    
    public Optional<Person> findByFullname(String fullname);
    public boolean existsByFullname(String fullname);
    
    
}
