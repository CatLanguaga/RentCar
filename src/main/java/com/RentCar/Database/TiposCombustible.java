package com.RentCar.Database;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
public class TiposCombustible implements Serializable {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    
    private String Descripcion;
    
    private String Estado;
        
    //Constructores

    public TiposCombustible() {
    }

    public TiposCombustible(String Descripcion, String Estado) {
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public TiposCombustible(int Id, String Descripcion, String Estado) {
        this.Id = Id;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    
    
}
