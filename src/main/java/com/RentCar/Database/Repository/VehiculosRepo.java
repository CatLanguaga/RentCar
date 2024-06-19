package com.RentCar.Database.Repository;

import com.RentCar.Database.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculosRepo 
        extends JpaRepository<Vehiculos, Integer> {
    
}
