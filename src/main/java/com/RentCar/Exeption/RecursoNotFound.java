package com.RentCar.Exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNotFound extends RuntimeException{
    
    public RecursoNotFound(String mensaje){
        super(mensaje);
    }

    
}
