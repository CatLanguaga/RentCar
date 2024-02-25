package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Marcas;
import com.RentCar.Database.Repository.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Marcas")
public class ControlMarcas {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlMarcas(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearMarcas(Marcas c){
        
        PS.CrearMarcas(c);
    }
    
    @PutMapping
    public void EditarMarca(Marcas c){
        
        PS.EditarMarcas(c);
    }
    
    @DeleteMapping("/Marcas/{id}")
    public void ElimMarca(@PathVariable("id") long id){
        
        PS.ElimMarcas(id);
    }
    
    @GetMapping
    public void ObtenerMarca(){
        
        PS.obtenerMarcas();        
    }
    
    @GetMapping("/Marcas/{id}")
    public void ObtenerMarcas(@PathVariable("id") long id){
        
        PS.obtenerMarcas(id);        
    }
    
}
