package com.example.PrimerAPI;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class PrimerApiApplication {
        
    DataBase db;

    public static void main(String[] args) {
        
        
        SpringApplication.run(PrimerApiApplication.class, args);
    }

    @GetMapping("/")
    public String inicio(){
        return "Hola Mundo";
    }


    @GetMapping("/persona")
    public Persona prueba(){
        Persona temporal = new Persona("12343", "paco", "perez", "232323", "paco@mail.com");
        return temporal;
    }
    @GetMapping("/listaPersonas")
    public List<Persona> listado() {
        DataBase db = new DataBase();
        List<Persona> listado = new ArrayList<>();
        ResultSet response = db.listaPersonas();
        
        if(response == null){
            Persona temporal = new Persona("No Hay", "No Hay", "No Hay", "No Hay", "No Hay");
            listado.add(temporal);
            return listado;
        }
        
        try { 
            do {
                Persona persona = new Persona(response.getString("cedula"), response.getString("nombres"), response.getString("apellidos"), response.getString("telefono"), response.getString("email"));
                listado.add(persona);
            } while (response.next());
            
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }

        return listado;
       
    }

    @GetMapping("/getPersona")
    public String getPersona(@RequestParam String cedula  ){
        return "La persona buscada es: "+cedula;
    } 
            
}
