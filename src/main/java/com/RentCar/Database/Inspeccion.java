package com.RentCar.Database;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Inspeccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Inspeccion() {
    }

    public Inspeccion(Vehiculos Vehiculo, Clientes Cliente, boolean TieneRalladuras, int CantidadCombustible, boolean GomaRespuesta, boolean TieneGato, boolean RoturasCristal, String Gomas, Date fecha, Empleados Empleado, String Descripcion, String Estado) {
        this.Vehiculo = Vehiculo;
        this.Cliente = Cliente;
        this.TieneRalladuras = TieneRalladuras;
        this.CantidadCombustible = CantidadCombustible;
        this.GomaRespuesta = GomaRespuesta;
        this.TieneGato = TieneGato;
        this.RoturasCristal = RoturasCristal;
        this.Gomas = Gomas;
        this.fecha = fecha;
        this.Empleado = Empleado;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public Inspeccion(int Id, Vehiculos Vehiculo, Clientes Cliente, boolean TieneRalladuras, int CantidadCombustible, boolean GomaRespuesta, boolean TieneGato, boolean RoturasCristal, String Gomas, Date fecha, Empleados Empleado, String Descripcion, String Estado) {
        this.Id = Id;
        this.Vehiculo = Vehiculo;
        this.Cliente = Cliente;
        this.TieneRalladuras = TieneRalladuras;
        this.CantidadCombustible = CantidadCombustible;
        this.GomaRespuesta = GomaRespuesta;
        this.TieneGato = TieneGato;
        this.RoturasCristal = RoturasCristal;
        this.Gomas = Gomas;
        this.fecha = fecha;
        this.Empleado = Empleado;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    
    
    
}
