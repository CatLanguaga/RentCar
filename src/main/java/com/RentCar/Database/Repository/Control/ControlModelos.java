package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Modelos;
import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.ModelosService;
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
public class ControlModelos {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlModelos.class);
        
        @Autowired
        private ModelosService modelosServicio;
        
        @GetMapping("/modelos")
        public List<Modelos> obetenerModelos(){
        
            List<Modelos> modelos = this.modelosServicio.ListarModelos();
            
            logger.info("Modeloss Obtenidos:");
            
            modelos.forEach(modelo -> logger.info(modelo.toString()));
            
            return modelos;       
        }
        
        @PostMapping("/modelos")
        public Modelos agregarModelos(@RequestBody Modelos modelo){
        
            logger.info("Modelos a agregar: " + modelo);
            
            return this.modelosServicio.guardarModelos(modelo);
        }
        
        @GetMapping("/modelos/{id}")
        public ResponseEntity<Modelos> obtenerModelosPorId(
                @PathVariable int id){
            Modelos modelo =
                    this.modelosServicio.BuscarModeloPorID(id);
            if(modelo != null)
                return ResponseEntity.ok(modelo);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/modelos/{id}")
        public ResponseEntity<Modelos> actualizarModelos(
                @PathVariable int id,
                @RequestBody Modelos g){
            Modelos modelo = this.modelosServicio.BuscarModeloPorID(id);
            if(modelo == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            modelo.setDescripcion(g.getDescripcion());
            modelo.setEstado(g.getEstado());
            this.modelosServicio.guardarModelos(modelo);
            return ResponseEntity.ok(modelo);
        }

        @DeleteMapping("/modelos/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarModelos(@PathVariable int id){
            Modelos modelos = modelosServicio.BuscarModeloPorID(id);
            if (modelos == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.modelosServicio.eliminarModelo(modelos.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
