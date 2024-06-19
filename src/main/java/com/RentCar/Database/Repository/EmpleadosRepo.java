package com.RentCar.Database.Repository;

import com.RentCar.Database.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepo 
        extends JpaRepository<Empleados, Integer> {
    
}
