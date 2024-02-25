package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Repository.PersistenceService;
import com.RentCar.Database.TiposVehiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/TiposVehiculos")
public class ControlTiposVehiculos {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlTiposVehiculos(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearTiposVehiculos(TiposVehiculos c){
        
        PS.CrearTiposVehiculos(c);
    }
    
    @PutMapping
    public void EditarTiposVehiculos(TiposVehiculos c){
        
        PS.EditarTiposVehiculos(c);
    }
    
    @DeleteMapping("/TiposVehiculos/{id}")
    public void ElimTiposVehiculos(@PathVariable("id") long id){
        
        PS.ElimTiposVehiculos(id);
    }
    
    @GetMapping
    public void ObtenerTiposVehiculos(){
        
        PS.obtenerTiposVehiculos();        
    }
    
    @GetMapping("/TiposVehiculos/{id}")
    public void ObtenerTiposVehiculos(@PathVariable("id") long id){
        
        PS.obtenerTiposVehiculos(id);        
    }
    
}
