package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.TiposCombustible;
import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.TiposCombustibleService;
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
public class ControlTiposCombustible {
    
            private static final Logger logger = LoggerFactory.getLogger(ControlTiposCombustible.class);
        
        @Autowired
        private TiposCombustibleService tiposCombustibleServicio;
        
        @GetMapping("/tiposCombustible")
        public List<TiposCombustible> obetenerTiposCombustible(){
        
            List<TiposCombustible> tiposCombustible = this.tiposCombustibleServicio.ListarTiposCombustible();
            
            logger.info("TiposCombustibles Obtenidos:");
            
            tiposCombustible.forEach(marca -> logger.info(marca.toString()));
            
            return tiposCombustible;       
        }
        
        @PostMapping("/tiposCombustible")
        public TiposCombustible agregarTiposCombustible(@RequestBody TiposCombustible marca){
        
            logger.info("TiposCombustible a agregar: " + marca);
            
            return this.tiposCombustibleServicio.guardarTiposCombustible(marca);
        }
        
        @GetMapping("/tiposCombustible/{id}")
        public ResponseEntity<TiposCombustible> obtenerTiposCombustiblePorId(
                @PathVariable int id){
            TiposCombustible marca =
                    this.tiposCombustibleServicio.BuscarTiposCombustiblePorID(id);
            if(marca != null)
                return ResponseEntity.ok(marca);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/tiposCombustible/{id}")
        public ResponseEntity<TiposCombustible> actualizarTiposCombustible(
                @PathVariable int id,
                @RequestBody TiposCombustible e){
            TiposCombustible marca = this.tiposCombustibleServicio.BuscarTiposCombustiblePorID(id);
            if(marca == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            marca.setDescripcion(e.getDescripcion());
            marca.setEstado(e.getEstado());
            this.tiposCombustibleServicio.guardarTiposCombustible(marca);
            return ResponseEntity.ok(marca);
        }

        @DeleteMapping("/tiposCombustible/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarTiposCombustible(@PathVariable int id){
            TiposCombustible tiposCombustible = tiposCombustibleServicio.BuscarTiposCombustiblePorID(id);
            if (tiposCombustible == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.tiposCombustibleServicio.eliminarTiposCombustible(tiposCombustible.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
