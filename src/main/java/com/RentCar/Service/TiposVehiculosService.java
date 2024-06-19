package com.RentCar.Service;

import com.RentCar.Database.Repository.TiposVehiculosRepo;
import com.RentCar.Database.TiposVehiculos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiposVehiculosService {
    
    @Autowired
    private TiposVehiculosRepo TiposVehiculosRepo;
    
    
    public List<TiposVehiculos> ListarTiposVehiculos() {
        return TiposVehiculosRepo.findAll();
    }

    
    public TiposVehiculos BuscarTiposVehiculosPorID(Integer idTiposVehiculos) {
        TiposVehiculos TipoVehiculo = TiposVehiculosRepo.findById(idTiposVehiculos).orElse(null);
        return TipoVehiculo;
    } 

    
    public TiposVehiculos guardarTiposVehiculos(TiposVehiculos producto) {
        
        return TiposVehiculosRepo.save(producto);
    }

    
    public void eliminarTiposVehiculos(Integer id) {
        TiposVehiculosRepo.deleteById(id);
    }
    
}
