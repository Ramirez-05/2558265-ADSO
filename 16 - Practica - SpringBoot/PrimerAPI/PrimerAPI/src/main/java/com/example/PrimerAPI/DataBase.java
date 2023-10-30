package com.example.PrimerAPI;

import java.sql.*;

public class DataBase {
    
    Connection conexion;
    Statement manipularDB;
    
    public DataBase(){
        String hostname = "localhost";
        String puerto = "3306";
        String user_name = "root";
        String password = "";
        String database_name = "app_java";
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+database_name;
        
        try {
            this.conexion = DriverManager.getConnection(url, user_name, password);
            this.manipularDB = this.conexion.createStatement();
            System.out.println("Conexion a DataBase Exitosa.");
        } catch (SQLException ex) {
            System.out.println("Error en conexion a base de dato: "+ex.getMessage());
        }
    }
    
    public ResultSet listaPersonas(){
        ResultSet listado = null;
        
        try {
            String consulta = "SELECT * FROM personas";
            listado = this.manipularDB.executeQuery(consulta);
            listado.next();
            
            if (listado.getRow()==1) {
                return listado;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            System.out.println("Error en SELECT: "+ex.getMessage());
        }
        
        return listado;
    }
    
}
