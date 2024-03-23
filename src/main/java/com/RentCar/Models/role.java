package com.RentCar.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
@Data
public class role implements GrantedAuthority{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String authority;

    public role(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public role(String authority) {
        this.authority = authority;
    }
    
    @Override
    public String getAuthority() {
        return this.authority; 
    }
     
}
