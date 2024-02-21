package com.RentCar.Database;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Marcas implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Descripcion;
    
    private String Estado;

    //Constructores
    
    public Marcas() {
    }

    public Marcas(String Descripcion, String Estado) {
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public Marcas(int Id, String Descripcion, String Estado) {
        this.Id = Id;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    
    
    
}
