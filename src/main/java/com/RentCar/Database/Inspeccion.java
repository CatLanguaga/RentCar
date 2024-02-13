package com.RentCar.Database;

import jakarta.persistence.OneToOne;
import java.util.Date;


public class Inspeccion {
    
    private int Id;
    
    @OneToOne
    private Vehiculos Vehiculo;
    
    @OneToOne
    private Clientes Cliente;
    
    private boolean TieneRalladuras;
    
    private int CantidadCombustible;
    
    private boolean GomaRespuesta;
    
    private boolean TieneGato;
    
    private boolean RoturasCristal;
    
    private String Gomas;
    
    private Date fecha;
    
    @OneToOne
    private Empleados Empleado;
    
    private String Descripcion;
    
    private String Estado;
    
}
