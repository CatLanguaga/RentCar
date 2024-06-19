package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Marcas;
import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.MarcasService;
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
public class ControlMarcas {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlMarcas.class);
        
        @Autowired
        private MarcasService marcasServicio;
        
        @GetMapping("/marcas")
        public List<Marcas> obetenerMarcas(){
        
            List<Marcas> marcas = this.marcasServicio.ListarMarcas();
            
            logger.info("Marcass Obtenidos:");
            
            marcas.forEach(marca -> logger.info(marca.toString()));
            
            return marcas;       
        }
        
        @PostMapping("/marcas")
        public Marcas agregarMarcas(@RequestBody Marcas marca){
        
            logger.info("Marcas a agregar: " + marca);
            
            return this.marcasServicio.guardarMarcas(marca);
        }
        
        @GetMapping("/marcas/{id}")
        public ResponseEntity<Marcas> obtenerMarcasPorId(
                @PathVariable int id){
            Marcas marca =
                    this.marcasServicio.BuscarMarcasPorID(id);
            if(marca != null)
                return ResponseEntity.ok(marca);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/marcas/{id}")
        public ResponseEntity<Marcas> actualizarMarcas(
                @PathVariable int id,
                @RequestBody Marcas e){
            Marcas marca = this.marcasServicio.BuscarMarcasPorID(id);
            if(marca == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            marca.setDescripcion(e.getDescripcion());
            marca.setEstado(e.getEstado());
            this.marcasServicio.guardarMarcas(marca);
            return ResponseEntity.ok(marca);
        }

        @DeleteMapping("/marcas/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarMarcas(@PathVariable int id){
            Marcas marcas = marcasServicio.BuscarMarcasPorID(id);
            if (marcas == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.marcasServicio.eliminarMarcas(marcas.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
