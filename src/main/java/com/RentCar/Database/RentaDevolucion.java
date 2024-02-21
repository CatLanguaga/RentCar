package com.RentCar.Database;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class RentaDevolucion implements Serializable {
       
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public RentaDevolucion() {
    }

    public RentaDevolucion(int Empleado, int Vehiculo, int Cliente, Date FechaRenta, Date FechaDevolucion, int MontoXDia, int CantidadDias, String Comentario, String Estado) {
        this.Empleado = Empleado;
        this.Vehiculo = Vehiculo;
        this.Cliente = Cliente;
        this.FechaRenta = FechaRenta;
        this.FechaDevolucion = FechaDevolucion;
        this.MontoXDia = MontoXDia;
        this.CantidadDias = CantidadDias;
        this.Comentario = Comentario;
        this.Estado = Estado;
    }

    public RentaDevolucion(long Id, int Empleado, int Vehiculo, int Cliente, Date FechaRenta, Date FechaDevolucion, int MontoXDia, int CantidadDias, String Comentario, String Estado) {
        this.Id = Id;
        this.Empleado = Empleado;
        this.Vehiculo = Vehiculo;
        this.Cliente = Cliente;
        this.FechaRenta = FechaRenta;
        this.FechaDevolucion = FechaDevolucion;
        this.MontoXDia = MontoXDia;
        this.CantidadDias = CantidadDias;
        this.Comentario = Comentario;
        this.Estado = Estado;
    }
    
    
    
}
