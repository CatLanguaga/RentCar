package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Inspeccion;
import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.InspeccionService;
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
public class ControlInspeccion {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlInspeccion.class);
        
        @Autowired
        private InspeccionService InspeccionServicio;
        
        @GetMapping("/inspeccion")
        public List<Inspeccion> obetenerInspeccion(){
        
            List<Inspeccion> inspeccions = this.InspeccionServicio.ListarInspeccion();
            
            logger.info("Inspeccions Obtenidos:");
            
            inspeccions.forEach(inspeccion -> logger.info(inspeccion.toString()));
            
            return inspeccions;       
        }
        
        @PostMapping("/inspeccion")
        public Inspeccion agregarInspeccion(@RequestBody Inspeccion inspeccion){
        
            logger.info("Inspeccion a agregar: " + inspeccion);
            
            return this.InspeccionServicio.guardarInspeccion(inspeccion);
        }
        
        @GetMapping("/inspeccion/{id}")
        public ResponseEntity<Inspeccion> obtenerInspeccionPorId(
                @PathVariable int id){
            Inspeccion inspeccion =
                    this.InspeccionServicio.BuscarInspeccionPorID(id);
            if(inspeccion != null)
                return ResponseEntity.ok(inspeccion);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/inspeccion/{id}")
        public ResponseEntity<Inspeccion> actualizarInspeccion(
                @PathVariable int id,
                @RequestBody Inspeccion a){
            Inspeccion inspeccion = this.InspeccionServicio.BuscarInspeccionPorID(id);
            if(inspeccion == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            inspeccion.setVehiculo(a.getVehiculo()); 
            inspeccion.setCliente(a.getCliente());
            inspeccion.setEstado(a.getEstado());
            inspeccion.setTieneRalladuras(a.getTieneRalladuras());
            inspeccion.setCantidadCombustible(a.getCantidadCombustible());
            inspeccion.setFecha(a.getFecha());
            inspeccion.setGomaRespuesta(a.getGomaRespuesta());
            inspeccion.setRoturasCristal(a.getRoturasCristal());
            inspeccion.setTieneGato(a.getTieneGato());
            inspeccion.setVehiculo(a.getVehiculo());
            inspeccion.setDescripcion(a.getDescripcion());
            inspeccion.setGomas(a.getGomas());
            this.InspeccionServicio.guardarInspeccion(inspeccion);
            return ResponseEntity.ok(inspeccion);
        }

        @DeleteMapping("/inspeccion/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarInspeccion(@PathVariable int id){
            Inspeccion Inspeccion = InspeccionServicio.BuscarInspeccionPorID(id);
            if (Inspeccion == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.InspeccionServicio.eliminarInspeccion(Inspeccion.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
