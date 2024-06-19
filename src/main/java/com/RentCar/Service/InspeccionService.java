package com.RentCar.Service;

import com.RentCar.Database.Inspeccion;
import com.RentCar.Database.Repository.InspeccionRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspeccionService {
    
    @Autowired
    private InspeccionRepo InspeccionRepo;
    
    
    public List<Inspeccion> ListarInspeccion() {
        return InspeccionRepo.findAll();
    }

    
    public Inspeccion BuscarInspeccionPorID(Integer idInspeccion) {
        Inspeccion inspeccion = InspeccionRepo.findById(idInspeccion).orElse(null);
        return inspeccion;
    } 

    
    public Inspeccion guardarInspeccion(Inspeccion producto) {
        
        return InspeccionRepo.save(producto);
    }

    
    public void eliminarInspeccion(Integer id) {
        InspeccionRepo.deleteById(id);
    }
    
}
