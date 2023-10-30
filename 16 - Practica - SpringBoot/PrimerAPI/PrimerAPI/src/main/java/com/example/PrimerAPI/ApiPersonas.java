package com.example.PrimerAPI;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class ApiPersonas {
    

    
    @GetMapping("/enpoint02")
    public String prueba02() {
        return "Este es un endpoint del segundo Archivo.";
    }    
    
}
