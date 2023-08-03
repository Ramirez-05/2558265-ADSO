package Clases;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DataBase {
    
    Connection conexion;
    Statement manipularDB;
    
    public DataBase (){
           
        String hostname = "localhost";
	String puerto = "3306";
        String user = "root";
        String password = "";
	String databasename = "app_java";
	
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+databasename;
        
  
        
        try {
            this.conexion = DriverManager.getConnection(url, user, password);
            this.manipularDB = this.conexion.createStatement();
            System.out.println("Conexion a DataBase Exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en conexion a base de datos"+ex.getMessage());
        }     
        
    }
    
    
     public boolean insertarPersona(String cedula, String nombres, String apellidos, String telefono, String direccion, String email){
            boolean respuesta = false;
            
        try {
            String consulta = "INSERT INTO personas (cedula, nombres, apellidos, telefono, direccion, email) VALUES ('"+cedula+"','"+nombres+"','"+apellidos+"','"+telefono+"','"+direccion+"','"+email+"')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            
            if(resultado == 1){
                respuesta = true;
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar: "+ex.getMessage());   
         
           
        }
     return respuesta;
     
     }
     
     public ResultSet listaPersonas(){
         
         ResultSet listado = null;
         
        try {
            String consulta = "SELECT * FROM personas";
            listado = this.manipularDB.executeQuery(consulta);
            
            listado.next();
            
            if(listado.getRow()==1){
                return listado;
            }else{
                return null;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error en SELECT"+ex.getMessage());
        }
        
        return listado;
     }
     
     public ResultSet buscarPersona(int cedula){
        ResultSet usuario = null;
             
        try {
            String consulta = "SELECT * FROM personas WHERE cedula = '"+cedula+"'";
            usuario = this.manipularDB.executeQuery(consulta);
            
            if(usuario.next()){
                return usuario;
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error en SELECT"+ex.getMessage());
        }
        
        return usuario;
         
     }
     
     public boolean modificarPersona(int cedula, String nombre, String apellido, String telefono, String direccion, String email){
         boolean respuesta = false;
         
        try {
            String modificar = "UPDATE personas SET nombres = '"+nombre+"', apellidos = '"+apellido+"' , telefono = '"+telefono+"' , direccion = '"+direccion+"', email = '"+email+"' WHERE cedula = '"+cedula+"'";
            int resultado = this.manipularDB.executeUpdate(modificar);
            
             if(resultado == 1){
             respuesta = true;
            }
        } catch (SQLException ex) {
               System.out.println("Error al modificar: "+ex.getMessage());   
        }
         
         return respuesta;
            
     }
     
     public boolean eliminarPersona(int cedula){
         boolean respuesta = false;
         
        try {
            String eliminar = "DELETE FROM personas WHERE cedula = '"+cedula+"'";
            int resultado = this.manipularDB.executeUpdate(eliminar);
            if(resultado == 1){
                respuesta = true; 
           }
        } catch (SQLException ex) {
           System.out.println("Error al eliminar: "+ex.getMessage()); 
        }
         
       return respuesta;
         
         
     }
     
     
     
     
}
