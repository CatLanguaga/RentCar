package com.RentCar.Service;

import com.RentCar.Database.Clientes;
import com.RentCar.Database.Repository.ClientesRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClientesRepo clienteRepo;
    
    
    public List<Clientes> ListarClientes() {
        return clienteRepo.findAll();
    }

    
    public Clientes BuscarClientePorID(Integer idCliente) {
        Clientes cliente = clienteRepo.findById(idCliente).orElse(null);
        return cliente;
    } 

    
    public Clientes guardarCliente(Clientes producto) {
        
        return clienteRepo.save(producto);
    }

    
    public void eliminarCliente(Integer id) {
        clienteRepo.deleteById(id);
    }
    
}
