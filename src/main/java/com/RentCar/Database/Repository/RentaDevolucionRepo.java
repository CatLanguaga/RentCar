package com.RentCar.Database.Repository;

import com.RentCar.Database.RentaDevolucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentaDevolucionRepo 
        extends JpaRepository<RentaDevolucion, Long>{
    
}
