package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Empleados;

import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.EmpleadosService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping()
public class ControlEmpleados {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlEmpleados.class);
        
        @Autowired
        private EmpleadosService empleadosServicio;
        
        @GetMapping("/empleados")
        public List<Empleados> obetenerEmpleados(){
        
            List<Empleados> empleados = this.empleadosServicio.ListarEmpleados();
            
            logger.info("Empleadoss Obtenidos:");
            
            empleados.forEach(empleado -> logger.info(empleado.toString()));
            
            return empleados;       
        }
        
        @PostMapping("/empleados")
        public Empleados agregarEmpleados(@RequestBody Empleados empleado){
        
            logger.info("Empleados a agregar: " + empleado);
            
            return this.empleadosServicio.guardarEmpleados(empleado);
        }
        
        @GetMapping("/empleados/{id}")
        public ResponseEntity<Empleados> obtenerEmpleadosPorId(
                @PathVariable int id){
            Empleados empleado =
                    this.empleadosServicio.BuscarEmpleadosPorID(id);
            if(empleado != null)
                return ResponseEntity.ok(empleado);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/empleados/{id}")
        public ResponseEntity<Empleados> actualizarEmpleados(
                @PathVariable int id,
                @RequestBody Empleados em){
            Empleados empleado = this.empleadosServicio.BuscarEmpleadosPorID(id);
            if(empleado == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            empleado.setCedula(em.getCedula());
            empleado.setEstado(em.getEstado());
            empleado.setFechaIngreso(em.getFechaIngreso());
            empleado.setNombre(em.getNombre());
            empleado.setPorcientoComision(em.getPorcientoComision());
            empleado.setTandaLabor(em.getTandaLabor());
            this.empleadosServicio.guardarEmpleados(empleado);
            return ResponseEntity.ok(empleado);
        }

        @DeleteMapping("/empleados/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarEmpleados(@PathVariable int id){
            Empleados empleados = empleadosServicio.BuscarEmpleadosPorID(id);
            if (empleados == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.empleadosServicio.eliminarEmpleados(empleados.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
