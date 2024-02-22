package com.RentCar.Database.Repository;

import com.RentCar.Database.Inspeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspeccionRepo 
        extends JpaRepository<Inspeccion, Long> {
    
}
