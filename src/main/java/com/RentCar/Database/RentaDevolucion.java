package com.RentCar.Database;

import jakarta.persistence.OneToOne;
import java.util.Date;


public class RentaDevolucion {
    
    private long Id;
    
    @OneToOne
    private int Empleado;
    
    @OneToOne
    private int Vehiculo;
    
    @OneToOne
    private int Cliente;
    
    private Date FechaRenta;
    
    private Date FechaDevolucion;
    
    private int MontoXDia;
    
    private int CantidadDias;
    
    private String Comentario;
    
    private String Estado;
    
}
