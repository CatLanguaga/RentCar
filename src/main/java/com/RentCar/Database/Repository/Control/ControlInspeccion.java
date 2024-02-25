package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Inspeccion;
import com.RentCar.Database.Repository.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Inspecciones")
public class ControlInspeccion {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlInspeccion(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearInspecciones(Inspeccion c){
        
        PS.CrearInspeccion(c);
    }
    
    @PutMapping
    public void EditarInspeccion(Inspeccion c){
        
        PS.EditarInspeccion(c);
    }
    
    @DeleteMapping("/Inspecciones/{id}")
    public void ElimInspeccion(@PathVariable("id") long id){
        
        PS.ElimInspeccion(id);
    }
    
    @GetMapping
    public void ObtenerInspeccion(){
        
        PS.obtenerInspeccion();        
    }
    
    @GetMapping("/Inspecciones/{id}")
    public void ObtenerInspecciones(@PathVariable("id") long id){
        
        PS.obtenerInspeccion(id);        
    }
    
}
