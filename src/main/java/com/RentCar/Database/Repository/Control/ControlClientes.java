package com.RentCar.Database.Repository.Control;

import com.RentCar.Database.Clientes;
import com.RentCar.Exeption.RecursoNotFound;
import com.RentCar.Service.ClienteService;
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
public class ControlClientes {
    
        private static final Logger logger = LoggerFactory.getLogger(ControlClientes.class);
        
        @Autowired
        private ClienteService clientesServicio;
        
        @GetMapping("/clientes")
        public List<Clientes> obetenerClientes(){
        
            List<Clientes> clientes = this.clientesServicio.ListarClientes();
            
            logger.info("Clientess Obtenidos:");
            
            clientes.forEach(cliente -> logger.info(cliente.toString()));
            
            return clientes;       
        }
        
        @PostMapping("/clientes")
        public Clientes agregarClientes(@RequestBody Clientes cliente){
        
            logger.info("Clientes a agregar: " + cliente);
            
            return this.clientesServicio.guardarCliente(cliente);
        }
        
        @GetMapping("/clientes/{id}")
        public ResponseEntity<Clientes> obtenerClientesPorId(
                @PathVariable int id){
            Clientes clientes =
                    this.clientesServicio.BuscarClientePorID(id);
            if(clientes != null)
                return ResponseEntity.ok(clientes);
            else
                throw new RecursoNotFound("No se encontro el id: " + id);
        }

        @PutMapping("/clientes/{id}")
        public ResponseEntity<Clientes> actualizarClientes(
                @PathVariable int id,
                @RequestBody Clientes c){
            Clientes cliente = this.clientesServicio.BuscarClientePorID(id);
            if(cliente == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
                cliente.setCedula(c.getCedula());
                cliente.setEstado(c.getEstado());
                cliente.setLimCredito(c.getLimCredito());
                cliente.setNoTargetaCR(c.getNoTargetaCR());
                cliente.setNombre(c.getNombre());
                cliente.setTipoPersona(c.getTipoPersona());
            return ResponseEntity.ok(cliente);
        }

        @DeleteMapping("/clientes/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarClientes(@PathVariable int id){
            Clientes clientes = clientesServicio.BuscarClientePorID(id);
            if (clientes == null)
                throw new RecursoNotFound("No se encontro el id: " + id);
            this.clientesServicio.eliminarCliente(clientes.getId());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    
}
