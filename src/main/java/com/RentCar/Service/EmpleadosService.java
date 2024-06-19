package com.RentCar.Service;

import com.RentCar.Database.Empleados;
import com.RentCar.Database.Repository.EmpleadosRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadosService {
    
    @Autowired
    private EmpleadosRepo EmpleadosRepo;
    
    
    public List<Empleados> ListarEmpleados() {
        return EmpleadosRepo.findAll();
    }

    
    public Empleados BuscarEmpleadosPorID(Integer idEmpleados) {
        Empleados empleado = EmpleadosRepo.findById(idEmpleados).orElse(null);
        return empleado;
    } 

    
    public Empleados guardarEmpleados(Empleados producto) {
        
        return EmpleadosRepo.save(producto);
    }

    
    public void eliminarEmpleados(Integer id) {
        EmpleadosRepo.deleteById(id);
    }
    
}
