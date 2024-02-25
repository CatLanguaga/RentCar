package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Clientes;
import com.RentCar.Database.Repository.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Clientes")
public class ControlClientes {
    
    private final PersistenceService PS;
    
    @Autowired
    public ControlClientes(PersistenceService PS) {
        this.PS = PS;
    }
    
    @PostMapping
    public void crearClientes(Clientes c){
        
        PS.CrearCliente(c);
    }
    
    @PutMapping
    public void EditarCliente(Clientes c){
        
        PS.EditarCliente(c);
    }
    
    @DeleteMapping("/Clientes/{id}")
    public void ElimCliente(@PathVariable("id") long id){
        
        PS.ElimCliente(id);
    }
    
    @GetMapping
    public void ObtenerCliente(){
        
        PS.obtenerCliente();        
    }
    
    @GetMapping("/Clientes/{id}")
    public void ObtenerClientes(@PathVariable("id") long id){
        
        PS.obtenerCliente(id);        
    }
}
