package com.RentCar.Database;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Entity
@Data
public class Empleados implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String Nombre;
    
    private int Cedula;
    
    private String TandaLabor;
    
    private int porcientoComision;
    
    private Date FechaIngreso;
    
    private String Estado;

    public Empleados() {
    }

    public Empleados(String Nombre, int Cedula, String TandaLabor, int porcientoComision, Date FechaIngreso, String Estado) {
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.TandaLabor = TandaLabor;
        this.porcientoComision = porcientoComision;
        this.FechaIngreso = FechaIngreso;
        this.Estado = Estado;
    }

    public Empleados(Long Id, String Nombre, int Cedula, String TandaLabor, int porcientoComision, Date FechaIngreso, String Estado) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Cedula = Cedula;
        this.TandaLabor = TandaLabor;
        this.porcientoComision = porcientoComision;
        this.FechaIngreso = FechaIngreso;
        this.Estado = Estado;
    }
    
    
}
