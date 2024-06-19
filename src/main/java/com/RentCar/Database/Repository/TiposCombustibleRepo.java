package com.RentCar.Database.Repository;

import com.RentCar.Database.TiposCombustible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposCombustibleRepo 
        extends JpaRepository<TiposCombustible, Integer>{
    
}
