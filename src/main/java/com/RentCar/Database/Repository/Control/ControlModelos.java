package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Modelos;
import com.RentCar.Database.Repository.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Modelos")
public class ControlModelos {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlModelos(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearModelos(Modelos c){
        
        PS.CrearModelos(c);
    }
    
    @PutMapping
    public void EditarModelo(Modelos c){
        
        PS.EditarModelos(c);
    }
    
    @DeleteMapping("/Modelos/{id}")
    public void ElimModelo(@PathVariable("id") long id){
        
        PS.ElimModelos(id);
    }
    
    @GetMapping
    public void ObtenerModelo(){
        
        PS.obtenerModelos();        
    }
    
    @GetMapping("/Modelos/{id}")
    public void ObtenerModelos(@PathVariable("id") long id){
        
        PS.obtenerModelos(id);
    }
    
}
