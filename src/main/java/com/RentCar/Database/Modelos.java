package com.RentCar.Database;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import lombok.Data;


@Entity
@Data
public class Modelos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    
    @OneToOne
    private LinkedList<Marcas> marca;
    
    private String Descripcion;
    
    private String Estado;
    
    //Constructores

    public Modelos() {
    }    
    
    public Modelos(Long Id, LinkedList<Marcas> marca, String Descripcion, String Estado) {
        this.Id = Id;
        this.marca = marca;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }

    public Modelos(LinkedList<Marcas> marca, String Descripcion, String Estado) {
        this.marca = marca;
        this.Descripcion = Descripcion;
        this.Estado = Estado;
    }
    
    
    
}
