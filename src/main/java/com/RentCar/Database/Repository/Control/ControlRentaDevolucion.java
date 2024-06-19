package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.RentaDevolucion;
import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.RentaDevolucionService;
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
public class ControlRentaDevolucion {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlRentaDevolucion.class);
        
        @Autowired
        private RentaDevolucionService rentaDevolucionServicio;
        
        @GetMapping("/rentaDevolucion")
        public List<RentaDevolucion> obetenerRentaDevolucion(){
        
            List<RentaDevolucion> rentaDevolucion = this.rentaDevolucionServicio.ListarRentaDevolucion();
            
            logger.info("RentaDevolucions Obtenidos:");
            
            rentaDevolucion.forEach(rentaDevolucione -> logger.info(rentaDevolucione.toString()));
            
            return rentaDevolucion;       
        }
        
        @PostMapping("/rentaDevolucion")
        public RentaDevolucion agregarRentaDevolucion(@RequestBody RentaDevolucion rentaDevolucion){
        
            logger.info("RentaDevolucion a agregar: " + rentaDevolucion);
            
            return this.rentaDevolucionServicio.guardarRentaDevolucion(rentaDevolucion);
        }
        
        @GetMapping("/rentaDevolucion/{id}")
        public ResponseEntity<RentaDevolucion> obtenerRentaDevolucionPorId(
                @PathVariable int id){
            RentaDevolucion rentaDevolucion =
                    this.rentaDevolucionServicio.BuscarRentaDevolucionPorID(id);
            if(rentaDevolucion != null)
                return ResponseEntity.ok(rentaDevolucion);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/rentaDevolucion/{id}")
        public ResponseEntity<RentaDevolucion> actualizarRentaDevolucion(
                @PathVariable int id,
                @RequestBody RentaDevolucion rd){
            RentaDevolucion rentaDevolucion = this.rentaDevolucionServicio.BuscarRentaDevolucionPorID(id);
            if(rentaDevolucion == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
                rentaDevolucion.setCantidadDias(rd.getCantidadDias());
                rentaDevolucion.setCliente(rd.getCliente());
                rentaDevolucion.setComentario(rd.getComentario());
                rentaDevolucion.setEmpleado(rd.getEmpleado());
                rentaDevolucion.setEstado(rd.getEstado());
                rentaDevolucion.setFechaDevolucion(rd.getFechaDevolucion());
                rentaDevolucion.setFechaRenta(rd.getFechaRenta());
                rentaDevolucion.setMontoXDia(rd.getMontoXDia());
            this.rentaDevolucionServicio.guardarRentaDevolucion(rentaDevolucion);
            return ResponseEntity.ok(rentaDevolucion);
        }

        @DeleteMapping("/rentaDevolucion/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarRentaDevolucion(@PathVariable int id){
            RentaDevolucion rentaDevolucion = rentaDevolucionServicio.BuscarRentaDevolucionPorID(id);
            if (rentaDevolucion == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.rentaDevolucionServicio.eliminarRentaDevolucion(rentaDevolucion.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
