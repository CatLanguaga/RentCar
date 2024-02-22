package com.RentCar.Database;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Entity
@Data
public class TiposVehiculos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    private String Descripcion;
    
    private String Estado;

    //Constructores
    
    public TiposVehiculos() {
    }

    public TiposVehiculos(String Descripcion, String Estado) {
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public TiposVehiculos(Long Id, String Descripcion, String Estado) {
        this.Id = Id;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    
    
}
