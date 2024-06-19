package com.RentCar.Service;

import com.RentCar.Database.Repository.TiposCombustibleRepo;
import com.RentCar.Database.TiposCombustible;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TiposCombustibleService {
    
    @Autowired
    private TiposCombustibleRepo TiposCombustibleRepo;
    
    
    public List<TiposCombustible> ListarTiposCombustible() {
        return TiposCombustibleRepo.findAll();
    }

    
    public TiposCombustible BuscarTiposCombustiblePorID(Integer idTiposCombustible) {
        TiposCombustible tipoCombustible = TiposCombustibleRepo.findById(idTiposCombustible).orElse(null);
        return tipoCombustible;
    } 

    
    public TiposCombustible guardarTiposCombustible(TiposCombustible producto) {
        
        return TiposCombustibleRepo.save(producto);
    }

    
    public void eliminarTiposCombustible(Integer id) {
        TiposCombustibleRepo.deleteById(id);
    }
    
}
