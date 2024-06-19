package com.RentCar.Database.Repository;

import com.RentCar.Database.Modelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelosRepo 
        extends JpaRepository<Modelos, Integer> {
    
}
