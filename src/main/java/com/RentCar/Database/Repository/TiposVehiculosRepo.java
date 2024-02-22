package com.RentCar.Database.Repository;

import com.RentCar.Database.TiposVehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposVehiculosRepo 
        extends JpaRepository<TiposVehiculos, Long> {
    
}
