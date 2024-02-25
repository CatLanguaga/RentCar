package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Repository.PersistenceService;
import com.RentCar.Database.Vehiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Vehiculos")
public class ControlVehiculos {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlVehiculos(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearVehiculos(Vehiculos c){
        
        PS.CrearVehiculos(c);
    }
    
    @PutMapping
    public void EditarVehiculos(Vehiculos c){
        
        PS.EditarVehiculos(c);
    }
    
    @DeleteMapping("/Vehiculos/{id}")
    public void ElimVehiculos(@PathVariable("id") long id){
        
        PS.ElimVehiculos(id);
    }
    
    @GetMapping
    public void ObtenerVehiculos(){
        
        PS.obtenerVehiculos();        
    }
    
    @GetMapping("/Vehiculos/{id}")
    public void ObtenerVehiculos(@PathVariable("id") long id){
        
        PS.obtenerVehiculos(id);        
    }
    
}
