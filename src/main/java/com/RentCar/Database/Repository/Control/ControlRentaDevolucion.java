package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.RentaDevolucion;
import com.RentCar.Database.Repository.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/RentaDevolucion")
public class ControlRentaDevolucion {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlRentaDevolucion(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearRentaDevolucion(RentaDevolucion c){
        
        PS.CrearRentaDevolucion(c);
    }
    
    @PutMapping
    public void EditarRentaDevolucion(RentaDevolucion c){
        
        PS.EditarRentaDevolucion(c);
    }
    
    @DeleteMapping("/RentaDevolucion/{id}")
    public void ElimRentaDevolucion(@PathVariable("id") long id){
        
        PS.ElimRentaDeolucion(id);
    }
    
    @GetMapping
    public void ObtenerRentaDevolucion(){
        
        PS.obtenerRentaDevolucion();        
    }
    
    @GetMapping("/RentaDevolucion/{id}")
    public void ObtenerRentaDevolucion(@PathVariable("id") long id){
        
        PS.obtenerRentaDevolucion(id);        
    }
    
}
