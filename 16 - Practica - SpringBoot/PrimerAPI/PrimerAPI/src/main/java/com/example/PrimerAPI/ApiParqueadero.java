package com.example.PrimerAPI;

import org.springframework.dao.DataAccessException;

import PackagesDB.DataBase;
import PackagesDB.ParqueaderoDB;
import Clases.Parking;
import Clases.ToolsApi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class ApiParqueadero {
    
    ParqueaderoDB parqueadero;
    
     public ApiParqueadero(){
        this.parqueadero = new ParqueaderoDB();
    }
    
    @GetMapping("/obtenerParqueaderos")
    public ResponseEntity<Object> listado() {
        List<Parking> listado = new ArrayList<>();
        ResultSet response = parqueadero.listaParqueaderos();

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            do {
                Parking temp = new Parking(
                        response.getString("nit"),
                        response.getString("nombre"),
                        response.getString("direccion"),
                        response.getString("telefono"),
                        response.getString("create_at"),
                        response.getString("update_at")
                );

                listado.add(temp);
            } while (response.next());

            Map<String, List<Parking>> responseMap = new HashMap<>();
            responseMap.put("registros", listado);

            return ResponseEntity.ok(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }    

    @PostMapping("/eliminarParqueadero")
    public ResponseEntity<Object> eliminarParqueadero(@RequestParam("nit") String nit) {
        try {
            if (nit != null && !nit.isEmpty()) {
                boolean eliminacionExitosa = parqueadero.eliminarParqueadero(nit);
                return ResponseEntity.ok( ToolsApi.createMaps(eliminacionExitosa, (eliminacionExitosa)? "OK##DELETE":"ERROR##DELETE" ) );
            } else {
                return ResponseEntity.ok( ToolsApi.createMaps(false, "ERROR##DATOS##POST") );
            }
        } catch (DataAccessException e) {
            return ResponseEntity.badRequest().body(ToolsApi.createMaps(false, "ERROR##SQL", e) );
        }
    }
    
    @PostMapping("/insertarParqueadero")
    public ResponseEntity<Object> insertarParqueadero(@RequestParam("nit") String nit,@RequestParam("nombre") String nombre,@RequestParam("direccion") String direccion,@RequestParam("telefono") String telefono) {
        try {
            if (!nit.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty()) {

                boolean insercionExitosa = parqueadero.insertarParqueadero(nit, nombre, direccion, telefono);

                if (insercionExitosa) {
                    Map<String, Object> insertResponse = new HashMap<>();
                    insertResponse.put("status", true);
                    insertResponse.put("message", "OK##PARQUEADERO##INSERT");
                    
                    System.out.println("-> resp: "+insertResponse.toString());
                    return ResponseEntity.ok(insertResponse);
                } else {
                    Map<String, Object> errorResponse = new HashMap<>();
                    errorResponse.put("status", false);
                    errorResponse.put("message", "ERROR##PARQUEADERO##INSERT");
                    System.out.println("-> resp: "+errorResponse.toString());
                    return ResponseEntity.badRequest().body(errorResponse);
                }
            } else {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("status", false);
                errorResponse.put("message", "ERROR##DATOS##POST");
                System.out.println("-> resp: "+errorResponse.toString());
                
                return ResponseEntity.badRequest().body(errorResponse);
            }
        } catch (DataAccessException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", false);
            errorResponse.put("message", "ERROR##SQL");
            errorResponse.put("exception", e.getMessage());
            System.out.println("-> resp: "+errorResponse.toString());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PostMapping("/actualizarParqueadero")
    public ResponseEntity<Object> actualizarParqueadero(@RequestParam("nit") String nit,@RequestParam("nombre") String nombre,@RequestParam("direccion") String direccion,@RequestParam("telefono") String telefono) {
        try {
            if (!nit.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !telefono.isEmpty()) {
                boolean actualizacionExitosa = parqueadero.actualizarParqueadero(nit, nombre, direccion, telefono);

                if (actualizacionExitosa) {
                    Map<String, Object> updateResponse = new HashMap<>();
                    updateResponse.put("status", true);
                    updateResponse.put("message", "OK##PARQUEADERO##UPDATE");
                    return ResponseEntity.ok(updateResponse);
                } else {
                    Map<String, Object> errorResponse = new HashMap<>();
                    errorResponse.put("status", false);
                    errorResponse.put("message", "ERROR##PARQUEADERO##UPDATE");
                    return ResponseEntity.badRequest().body(errorResponse);
                }
            } else {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("status", false);
                errorResponse.put("message", "ERROR##DATOS##POST");
                return ResponseEntity.badRequest().body(errorResponse);
            }
        } catch (DataAccessException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", false);
            errorResponse.put("message", "ERROR##SQL");
            errorResponse.put("exception", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
       
    @GetMapping("/verificarParqueadero")
    public ResponseEntity<Object> verificarParqueadero(@RequestParam(name = "nit", required = false) String nit) {
        try {
            if (nit != null && !nit.isEmpty()) {
                boolean exists = parqueadero.verificarParqueadero(nit);

                if (exists) {
                    System.out.println("paso api 1");
                    Map<String, Object> responseMap = new HashMap<>();
                    responseMap.put("status", true);

                    return ResponseEntity.ok(responseMap);
                } else {
                    System.out.println("paso api 2");
                    Map<String, Object> errorResponse = new HashMap<>();
                    errorResponse.put("status", false);
                    errorResponse.put("message", "No se encontraron resultados para el valor proporcionado en 'nit'.");

                    return ResponseEntity.ok(errorResponse);
                }
            } else {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("status", false);
                errorResponse.put("message", "El campo 'nit' en la solicitud GET está vacío.");

                return ResponseEntity.badRequest().body(errorResponse);
            }
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", false);
            errorResponse.put("message", "Error en la consulta SQL: " + e.getMessage());

            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
   
    
}
