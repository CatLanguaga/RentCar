package com.RentCar.Database;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
public class Vehiculos implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String Descripcion;
    
    private int NoChasis;
    
    private int NoMotor;
    
    private int NoPlaca;
    
    @OneToOne
    private TiposVehiculos TipoVehiculo;
    
    @OneToOne
    private Marcas Marca;
        
    @OneToOne
    private Modelos Modelo;
    
    @OneToOne
    private TiposCombustible Combustible;
    
    private String Estado;

    public Vehiculos() {
    }

    public Vehiculos(String Descripcion, int NoChasis, int NoMotor, int NoPlaca, TiposVehiculos TipoVehiculo, Marcas Marca, Modelos Modelo, TiposCombustible Combustible, String Estado) {
        this.Descripcion = Descripcion;
        this.NoChasis = NoChasis;
        this.NoMotor = NoMotor;
        this.NoPlaca = NoPlaca;
        this.TipoVehiculo = TipoVehiculo;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Combustible = Combustible;
        this.Estado = Estado;
    }

    public Vehiculos(Long Id, String Descripcion, int NoChasis, int NoMotor, int NoPlaca, TiposVehiculos TipoVehiculo, Marcas Marca, Modelos Modelo, TiposCombustible Combustible, String Estado) {
        this.Id = Id;
        this.Descripcion = Descripcion;
        this.NoChasis = NoChasis;
        this.NoMotor = NoMotor;
        this.NoPlaca = NoPlaca;
        this.TipoVehiculo = TipoVehiculo;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Combustible = Combustible;
        this.Estado = Estado;
    }
    
    
    
}
