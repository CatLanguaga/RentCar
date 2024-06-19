package com.RentCar.Service;

import com.RentCar.Database.Repository.VehiculosRepo;
import com.RentCar.Database.Vehiculos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculosService {
    
    @Autowired
    private VehiculosRepo vehiculosRepo;
    
    
    public List<Vehiculos> ListarVehiculos() {
        return vehiculosRepo.findAll();
    }

    
    public Vehiculos BuscarVehiculosPorID(Integer idVehiculos) {
        Vehiculos vehiculo = vehiculosRepo.findById(idVehiculos).orElse(null);
        return vehiculo;
    } 

    
    public Vehiculos guardarVehiculos(Vehiculos producto) {
        
        return vehiculosRepo.save(producto);
    }

    
    public void eliminarVehiculos(Integer id) {
        vehiculosRepo.deleteById(id);
        
    }
    
}
