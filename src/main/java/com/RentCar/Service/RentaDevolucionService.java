package com.RentCar.Service;

import com.RentCar.Database.RentaDevolucion;
import com.RentCar.Database.Repository.RentaDevolucionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentaDevolucionService {
    
        @Autowired
    private RentaDevolucionRepo RentaDevolucionRepo;
    
    
    public List<RentaDevolucion> ListarRentaDevolucion() {
        return RentaDevolucionRepo.findAll();
    }

    
    public RentaDevolucion BuscarRentaDevolucionPorID(Integer idRentaDevolucion) {
        RentaDevolucion RentaDevo = RentaDevolucionRepo.findById(idRentaDevolucion).orElse(null);
        return RentaDevo;
    } 

    
    public RentaDevolucion guardarRentaDevolucion(RentaDevolucion producto) {
        
        return RentaDevolucionRepo.save(producto);
    }

    
    public void eliminarRentaDevolucion(Integer id) {
        RentaDevolucionRepo.deleteById(id);
    }
    
}
