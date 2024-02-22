package com.RentCar.Database.Repository;

import com.RentCar.Database.Marcas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcasRepo 
        extends JpaRepository<Marcas, Long> {
    
}
