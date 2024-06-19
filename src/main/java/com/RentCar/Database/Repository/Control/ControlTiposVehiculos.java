package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.TiposVehiculos;
import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.TiposVehiculosService;
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
public class ControlTiposVehiculos {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlTiposVehiculos.class);
        
        @Autowired
        private TiposVehiculosService tiposVehiculosServicio;
        
        @GetMapping("/tiposVehiculos")
        public List<TiposVehiculos> obetenerTiposVehiculos(){
        
            List<TiposVehiculos> tiposVehiculos = this.tiposVehiculosServicio.ListarTiposVehiculos();
            
            logger.info("TiposVehiculoss Obtenidos:");
            
            tiposVehiculos.forEach(marca -> logger.info(marca.toString()));
            
            return tiposVehiculos;       
        }
        
        @PostMapping("/tiposVehiculos")
        public TiposVehiculos agregarTiposVehiculos(@RequestBody TiposVehiculos marca){
        
            logger.info("TiposVehiculos a agregar: " + marca);
            
            return this.tiposVehiculosServicio.guardarTiposVehiculos(marca);
        }
        
        @GetMapping("/tiposVehiculos/{id}")
        public ResponseEntity<TiposVehiculos> obtenerTiposVehiculosPorId(
                @PathVariable int id){
            TiposVehiculos marca =
                    this.tiposVehiculosServicio.BuscarTiposVehiculosPorID(id);
            if(marca != null)
                return ResponseEntity.ok(marca);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/tiposVehiculos/{id}")
        public ResponseEntity<TiposVehiculos> actualizarTiposVehiculos(
                @PathVariable int id,
                @RequestBody TiposVehiculos e){
            TiposVehiculos marca = this.tiposVehiculosServicio.BuscarTiposVehiculosPorID(id);
            if(marca == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            marca.setDescripcion(e.getDescripcion());
            marca.setEstado(e.getEstado());
            this.tiposVehiculosServicio.guardarTiposVehiculos(marca);
            return ResponseEntity.ok(marca);
        }

        @DeleteMapping("/tiposVehiculos/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarTiposVehiculos(@PathVariable int id){
            TiposVehiculos tiposVehiculos = tiposVehiculosServicio.BuscarTiposVehiculosPorID(id);
            if (tiposVehiculos == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.tiposVehiculosServicio.eliminarTiposVehiculos(tiposVehiculos.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
