
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    
    Connection conexion;
    Statement manipularDB;
    
    public DataBase(){
        String hostname = "3.16.83.65";
	String puerto = "3306";
        String user = "root";
        String password = "Adso2023!";
	String databasename = "gymapp";
        
        /*String hostname = "localhost";
	String puerto = "3306";
        String user = "root";
        String password = "";
	String databasename = "gymapp";*/
        
        String url = "jdbc:mysql://"+hostname+":"+puerto+"/"+databasename;
        
        try {
            this.conexion = DriverManager.getConnection(url, user, password);
            this.manipularDB = this.conexion.createStatement();
            System.out.println("Conexion a DataBase Exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en conexion a base de datos"+ex.getMessage());
        }   
    }
    
    
    
    ////////////////////////////////////// INSERTAR PERSONA //////////////////////////////////////////////////////
    
    public boolean insertarPersona(String cedula, String nombre, String apellido, String telefono,String correo, String direccion, String rh, String fechaNacimiento, String numeroEmergencia, String sexo, String discapacidad){
            boolean respuesta = false;
            
        try {
            String consulta = "INSERT INTO registrosuscriptor (documento, nombre, apellido, telefono,correo, direccion, rh, fechaNacimiento, numero_emergencia, sexo, discapacidad ) VALUES ('"+cedula+"','"+nombre+"','"+apellido+"','"+telefono+"','"+correo+"','"+direccion+"','"+rh+"','"+fechaNacimiento+"','"+numeroEmergencia+"','"+sexo+"','"+discapacidad+"')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if(resultado == 1){
                respuesta = true;
                System.out.println("Se inserto el usuario");
            } 
        } catch (SQLException ex) {
            System.out.println("Error al insertar: "+ex.getMessage());   
         
           
        }
     return respuesta;
     
     }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //////////////////////////////////// INSERTAR SUSCRIPTOR ///////////////////////////////////////////////////////////////
    
    
    public boolean insertarSub(String cedula, int dias, int opcMedioPago, int opc) {
        Boolean respuestaSub = false;

        try {
            // Obtener la fecha actual
            Calendar calendar = Calendar.getInstance();
            Date fechaActual = calendar.getTime();

            // Sumar días a la fecha actual
            int diasASumar = dias; // Cambia esto según tus necesidades
            calendar.add(Calendar.DAY_OF_YEAR, diasASumar);
            Date fechaFin = calendar.getTime();

            // Formatear las fechas para la consulta
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicioStr = dateFormat.format(fechaActual);
            String fechaFinStr = dateFormat.format(fechaFin);

            String consulta = "INSERT INTO suscripciones (id_tipo, documento, descuento, fecha_inicio, fecha_fin) VALUES ('" + opc + "','" + cedula + "','" + 0 + "','" + fechaInicioStr + "','" + fechaFinStr + "')";

            int resultado = this.manipularDB.executeUpdate(consulta);

            if (resultado == 1) {
                respuestaSub = true;
                System.out.println("Se insertó el sub");

                // Consultar el ID de la suscripción recién insertada
                String consultarIdSub = "SELECT id_suscripcion FROM suscripciones WHERE documento = '" + cedula + "' AND fecha_inicio = '" + fechaInicioStr + "'";
                ResultSet resultSet = this.manipularDB.executeQuery(consultarIdSub);

                if (resultSet.next()) {
                    int idSuscripcion = resultSet.getInt("id_suscripcion");
                    // Insertar el registro de pago con el ID de suscripción obtenido
                    String insertPago = "INSERT INTO pago (id_metodo, id_suscripcion) VALUES (" + opcMedioPago + "," + idSuscripcion + ")";
                    int resultadoPago = this.manipularDB.executeUpdate(insertPago);

                    if (resultadoPago == 1) {
                        System.out.println("Se insertó el registro de pago");
                    } else {
                        System.out.println("Error al insertar el registro de pago");
                    }
                } else {
                    System.out.println("No se pudo obtener el ID de la suscripción");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
        }

        return respuestaSub;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////// BUSCAR PERSONA //////////////////////////////////////////////////////////
   public ResultSet buscarPersona(String cedula) {
        ResultSet usuario = null;

        try {
            String consulta = "SELECT r.*, s.id_tipo, p.id_metodo "
                            + "FROM registrosuscriptor r "
                            + "INNER JOIN suscripciones s ON r.documento = s.documento "
                            + "INNER JOIN pago p ON s.id_suscripcion = p.id_suscripcion "
                            + "WHERE r.documento = '" + cedula + "'";
            usuario = this.manipularDB.executeQuery(consulta);

            System.out.println("Consulta exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en SELECT: " + ex.getMessage());
        }

        return usuario;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    ///////////////////////////////////// MODIFICAR PERSONA //////////////////////////////////////////////////////////////
    
   public boolean modificarPersona(String cedulaBuscar, String cedula, String nombre, String apellido, String telefono, String correo, String direccion, String rh, String fechaNacimiento, String numeroEmergencia, String sexo, String discapacidad, int opc, int opcMedioPago) {
        boolean respuesta = false;

        try {
            String modificar = "UPDATE registrosuscriptor SET documento = '" + cedula + "', nombre = '" + nombre + "', apellido = '" + apellido + "', telefono = '" + telefono + "', direccion = '" + direccion + "', correo = '" + correo + "', direccion = '" + direccion + "', rh = '" + rh + "', fechaNacimiento = '" + fechaNacimiento + "', numero_emergencia = '" + numeroEmergencia + "', sexo = '" + sexo + "', discapacidad = '" + discapacidad + "' WHERE documento = '" + cedulaBuscar + "'";
            int resultado = this.manipularDB.executeUpdate(modificar);

            if (resultado == 1) {
                respuesta = true;
                System.out.println("Se modificó el usuario");

                String consultaIdSuscripcion = "SELECT s.id_suscripcion FROM suscripciones s INNER JOIN registrosuscriptor r ON s.documento = r.documento WHERE r.documento = '" + cedula + "'";
                ResultSet resultadoIdSuscripcion = this.manipularDB.executeQuery(consultaIdSuscripcion);

                if (resultadoIdSuscripcion.next()) {
                    int idSuscripcion = resultadoIdSuscripcion.getInt("id_suscripcion");

                    String modificarSuscripcion = "UPDATE suscripciones SET id_tipo = " + opc + " WHERE id_suscripcion = " + idSuscripcion;
                    int resultadoModificacionSuscripcion = this.manipularDB.executeUpdate(modificarSuscripcion);

                    String modificarPago = "UPDATE pago SET id_metodo = " + opcMedioPago + " WHERE id_suscripcion = " + idSuscripcion;
                    int resultadoModificacionPago = this.manipularDB.executeUpdate(modificarPago);

                    if (resultadoModificacionSuscripcion == 1 && resultadoModificacionPago == 1) {
                        System.out.println("Se modificaron los datos de suscripción y método de pago");
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar: " + ex.getMessage());
        }

        return respuesta;
    }

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////////////// LISTA DE PERSONAS //////////////////////////////////////////////////////////
    
    public ResultSet listaPersonas() {
        ResultSet listado = null;

        try {
            String consulta = "SELECT r.nombre, r.apellido, s.fecha_inicio, s.fecha_fin "
                            + "FROM registrosuscriptor r "
                            + "INNER JOIN suscripciones s ON r.documento = s.documento"; // Ajusta la condición de JOIN según tu estructura de base de datos
            listado = this.manipularDB.executeQuery(consulta);

            System.out.println("\n LA CONSULTA SE HIZO DE MANERA CORRECTA \n");
            return listado;
        } catch (SQLException ex) {
            System.out.println("Error en SELECT: " + ex.getMessage());
        }

        return null;
    }
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    ////////////////////////////////////// BUSQUEDA PARA CONTAR TODAS LAS SUBS //////////////////////////////////////////////////////
    
      public int contarSuscripciones() {
        int cantidadSubscripciones = 0;

        try {
            String consulta = "SELECT COUNT(*) AS cantidad FROM suscripciones";
            ResultSet resultado = this.manipularDB.executeQuery(consulta);

            if (resultado.next()) {
                cantidadSubscripciones = resultado.getInt("cantidad");
            }
        } catch (SQLException ex) {
            System.out.println("Error en SELECT: " + ex.getMessage());
        }

        return cantidadSubscripciones;
    }

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
    ///////////////////////// CONSULTA PARA BUSCAR LOS PRECIOS /////////////////////////////////////////////////////////////////////
      
   public ResultSet buscarPrecios() {
        ResultSet resultado = null;

        try {
            String consulta = "SELECT ts.precio "
                           + "FROM tipo_suscripcion ts "
                           + "INNER JOIN suscripciones s ON ts.id_tipo = s.id_tipo";
            resultado = this.manipularDB.executeQuery(consulta);

            System.out.println("Se encontraron los precios de las suscripciones");
        } catch (SQLException ex) {
            System.out.println("Error en SELECT: " + ex.getMessage());
        }

        return resultado;
    }   
   
   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   public boolean verificarCedulaExistente(String cedula) {
        boolean cedulaExistente = false;

        try {
            String consulta = "SELECT COUNT(*) AS cantidad FROM registrosuscriptor WHERE documento = '" + cedula + "'";
            ResultSet resultado = this.manipularDB.executeQuery(consulta);

            if (resultado.next()) {
                int cantidad = resultado.getInt("cantidad");
                cedulaExistente = cantidad > 0;
            }
        } catch (SQLException ex) {
            System.out.println("Error al verificar cédula existente: " + ex.getMessage());
        }

        return cedulaExistente;
    }
   
   
    public boolean crearSub(String nombre, String descripcion, int valor, int dia){
        boolean crear_sub = false;
        
        try {
            String insert = "INSERT INTO tipo_suscripcion (nombre, descripcion, precio, dias) VALUES ('"+nombre+"', '"+descripcion+"', '"+valor+"', '"+dia+"') ";
            int resultado = this.manipularDB.executeUpdate(insert);
            
            if (resultado == 1) {
                crear_sub = true;
                System.out.println("Se insertó el La nueva sub");
            }else{
                System.out.println("No paso nada");
            }
            
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar: " + ex.getMessage());
        }
        
        return crear_sub;
        
    }
    
    
    
    
    public ResultSet obtenerNombresTiposSuscripcion() {
        ResultSet nombresTipos = null;

        try {
            String consulta = "SELECT * FROM tipo_suscripcion";
            nombresTipos = this.manipularDB.executeQuery(consulta);
            if (nombresTipos!=null) {
                nombresTipos.next();
            }
            System.out.println("Consulta exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " + ex.getMessage());
        }

        return nombresTipos;
    }
    
    
    
    
    public ResultSet obtenerPrecios(String nombre) {
        ResultSet precios = null;

        try {
            String consulta = "SELECT precio FROM tipo_suscripcion WHERE nombre = '"+nombre+"'";
            precios = this.manipularDB.executeQuery(consulta);

            System.out.println("Consulta exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " + ex.getMessage());
        }

        return precios;
    }
    
    
    public ResultSet obtenerDias(String tipo_suscripcion) {
        ResultSet precios = null;

        try {
            String consulta = "SELECT id_tipo,dias FROM tipo_suscripcion WHERE nombre = '"+tipo_suscripcion+"'";
            precios = this.manipularDB.executeQuery(consulta);

            System.out.println("Consulta exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " + ex.getMessage());
        }

        return precios;
    }
    
    
     public ResultSet obtenetNombresTipo(String nombre) {
        ResultSet nombresTipos = null;

        try {
            String consulta = "SELECT * FROM tipo_suscripcion WHERE nombre = '"+nombre+"'";
            nombresTipos = this.manipularDB.executeQuery(consulta);
            System.out.println("Consulta exitosa");
        } catch (SQLException ex) {
            System.out.println("Error en consulta: " + ex.getMessage());
        }

        return nombresTipos;
    }
    
     
    public boolean modificarSub(String nombre, String descripcion, int precio, int dias){
        boolean respuesta = false;
      
        try {
            String modificar = "UPDATE tipo_suscripcion SET descripcion = '"+descripcion+"' , precio = '"+precio+"', dias = '"+dias+"' WHERE nombre = '"+nombre+"' ";
            int resultado = this.manipularDB.executeUpdate(modificar);
            
            if (resultado == 1){
                respuesta = true;
            }
            
        } catch (SQLException ex) {
             System.out.println("Error al modificar: " + ex.getMessage());
        }
        
        return respuesta;
    }
    
    
        public boolean eliminarSub(String nombre){
        boolean respuesta = false;
      
        try {
            String eliminar = "DELETE FROM tipo_suscripcion WHERE nombre = '"+nombre+"'";
            int resultado = this.manipularDB.executeUpdate(eliminar);
            
            if (resultado == 1){
                respuesta = true;
            }
            
        } catch (SQLException ex) {
             System.out.println("Error al modificar: " + ex.getMessage());
        }
        
        return respuesta;
    }
    
    
    
    
    


    
    

    
    
   
   
   
   
   


}
