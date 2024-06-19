package com.RentCar.Service;

import com.RentCar.Database.Modelos;
import com.RentCar.Database.Repository.ModelosRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelosService {
    
    @Autowired
    private ModelosRepo ModeloRepo;
    
    
    public List<Modelos> ListarModelos() {
        return ModeloRepo.findAll();
    }

    
    public Modelos BuscarModeloPorID(Integer idModelo) {
        Modelos modelo = ModeloRepo.findById(idModelo).orElse(null);
        return modelo;
    } 

    
    public Modelos guardarModelos(Modelos producto) {
        
        return ModeloRepo.save(producto);
    }

    
    public void eliminarModelo(Integer id) {
        ModeloRepo.deleteById(id);
    }
    
}
