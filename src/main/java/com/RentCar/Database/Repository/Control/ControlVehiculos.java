package com.RentCar.Database.Repository.Control;

import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Database.Vehiculos;
import com.RentCar.Service.VehiculosService;
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
public class ControlVehiculos {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlVehiculos.class);
        
        @Autowired
        private VehiculosService vehiculosServicio;
        
        @GetMapping("/vehiculos")
        public List<Vehiculos> obetenerVehiculos(){
        
            List<Vehiculos> vehiculos = this.vehiculosServicio.ListarVehiculos();
            
            logger.info("Vehiculoss Obtenidos:");
            
            vehiculos.forEach(vehiculo -> logger.info(vehiculo.toString()));
            
            return vehiculos;       
        }
        
        @PostMapping("/vehiculos")
        public Vehiculos agregarVehiculos(@RequestBody Vehiculos vehiculo){
        
            logger.info("Vehiculos a agregar: " + vehiculo);
            
            return this.vehiculosServicio.guardarVehiculos(vehiculo);
        }
        
        @GetMapping("/vehiculos/{id}")
        public ResponseEntity<Vehiculos> obtenerVehiculosPorId(
                @PathVariable int id){
            Vehiculos vehiculo =
                    this.vehiculosServicio.BuscarVehiculosPorID(id);
            if(vehiculo != null)
                return ResponseEntity.ok(vehiculo);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/vehiculos/{id}")
        public ResponseEntity<Vehiculos> actualizarVehiculos(
                @PathVariable int id,
                @RequestBody Vehiculos vehiculoRecibido){
            Vehiculos vehiculo = this.vehiculosServicio.BuscarVehiculosPorID(id);
            if(vehiculo == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            vehiculo.setDescripcion(vehiculoRecibido.getDescripcion());
            vehiculo.setEstado(vehiculoRecibido.getEstado());
            this.vehiculosServicio.guardarVehiculos(vehiculo);
            return ResponseEntity.ok(vehiculo);
        }

        @DeleteMapping("/vehiculos/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarVehiculos(@PathVariable int id){
            Vehiculos vehiculos = vehiculosServicio.BuscarVehiculosPorID(id);
            if (vehiculos == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.vehiculosServicio.eliminarVehiculos(vehiculos.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
}
