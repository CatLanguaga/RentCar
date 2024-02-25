package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Repository.PersistenceService;
import com.RentCar.Database.TiposCombustible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/TiposCombustible")
public class ControlTiposCombustible {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlTiposCombustible(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearTiposCombustible(TiposCombustible c){
        
        PS.CrearTiposCombustible(c);
    }
    
    @PutMapping
    public void EditarTiposCombustible(TiposCombustible c){
        
        PS.EditarTiposCombustible(c);
    }
    
    @DeleteMapping("/TiposCombustible/{id}")
    public void ElimTiposCombustible(@PathVariable("id") long id){
        
        PS.ElimTiposCombustible(id);
    }
    
    @GetMapping
    public void ObtenerTiposCombustible(){
        
        PS.obtenerTiposCombustible();        
    }
    
    @GetMapping("/TiposCombustible/{id}")
    public void ObtenerTiposCombustible(@PathVariable("id") long id){
        
        PS.obtenerTiposCombustible(id);        
    }
    
}
