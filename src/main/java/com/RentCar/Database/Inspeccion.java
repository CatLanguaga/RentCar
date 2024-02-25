package com.RentCar.Database;

import jakarta.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class Inspeccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @OneToOne
    private Vehiculos Vehiculo;
    
    @OneToOne
    private Clientes Cliente;
    
    private String TieneRalladuras;
    
    private int CantidadCombustible;
    
    private String GomaRespuesta;
    
    private String TieneGato;
    
    private String RoturasCristal;
    
    private String Gomas;
    
    private Date fecha;
    
    @OneToOne
    private Empleados Empleado;
    
    private String Descripcion;
    
    private String Estado;

    public Inspeccion() {
    }

    public Inspeccion(Vehiculos Vehiculo, Clientes Cliente, String TieneRalladuras, int CantidadCombustible, String GomaRespuesta, String TieneGato, String RoturasCristal, String Gomas, Date fecha, Empleados Empleado, String Descripcion, String Estado) {
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

    public Inspeccion(Long Id, Vehiculos Vehiculo, Clientes Cliente, String TieneRalladuras, int CantidadCombustible, String GomaRespuesta, String TieneGato, String RoturasCristal, String Gomas, Date fecha, Empleados Empleado, String Descripcion, String Estado) {
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
