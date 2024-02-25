package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Empleados;
import com.RentCar.Database.Repository.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Empleados")
public class ControlEmpleados {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlEmpleados(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearEmpleados(Empleados c){
        
        PS.CrearEmpleado(c);
    }
    
    @PutMapping
    public void EditarEmpleado(Empleados c){
        
        PS.EditarEmpleado(c);
    }
    
    @DeleteMapping("/Empleados/{id}")
    public void ElimEmpleado(@PathVariable("id") long id){
        
        PS.ElimEmpleado(id);
    }
    
    @GetMapping
    public void ObtenerEmpleado(){
        
        PS.obtenerEmpleado();        
    }
    
    @GetMapping("/Empleados/{id}")
    public void ObtenerEmpleados(@PathVariable("id") long id){
        
        PS.obtenerEmpleado(id);        
    }
    
}
