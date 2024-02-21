package com.RentCar.Database;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
public class Clientes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Nombre;
    
    private int NoTargetaCR;

    private int LimCredito;
    
    private String TipoPersona;

    private String Estado;
    
    //Constructores

    public Clientes() {
    }

    public Clientes(String Nombre, int NoTargetaCR, int LimCredito, String TipoPersona, String Estado) {
        this.Nombre = Nombre;
        this.NoTargetaCR = NoTargetaCR;
        this.LimCredito = LimCredito;
        this.TipoPersona = TipoPersona;
        this.Estado = Estado;
    }

    public Clientes(int Id, String Nombre, int NoTargetaCR, int LimCredito, String TipoPersona, String Estado) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.NoTargetaCR = NoTargetaCR;
        this.LimCredito = LimCredito;
        this.TipoPersona = TipoPersona;
        this.Estado = Estado;
    }
    
    
    
}
