package com.RentCar.Service;

import com.RentCar.Database.Marcas;
import com.RentCar.Database.Repository.MarcasRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcasService {
    
    @Autowired
    private MarcasRepo MarcasRepo;
    
    
    public List<Marcas> ListarMarcas() {
        return MarcasRepo.findAll();
    }

    
    public Marcas BuscarMarcasPorID(Integer idMarcas) {
        Marcas marcas = MarcasRepo.findById(idMarcas).orElse(null);
        return marcas;
    } 

    
    public Marcas guardarMarcas(Marcas producto) {
        
        return MarcasRepo.save(producto);
    }

    
    public void eliminarMarcas(Integer id) {
        MarcasRepo.deleteById(id);
    }
    
}
