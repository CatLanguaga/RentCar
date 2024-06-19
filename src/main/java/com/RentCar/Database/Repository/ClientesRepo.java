package com.RentCar.Database.Repository;

import com.RentCar.Database.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepo 
        extends JpaRepository<Clientes, Integer>{
    
}
