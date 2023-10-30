package PackagesDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParqueaderoDB extends DataBase{
    
    public ParqueaderoDB(){
        System.out.println("Estamos en el constructor del ParqueaderDB");
    }
    
    public ResultSet listaParqueaderos(){
        ResultSet listado = null;
        try {
            String consulta = "SELECT * FROM parqueadero";
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
    
    public boolean eliminarParqueadero(String nit) {
        boolean respuesta = false;
            try {
                String consulta = "DELETE FROM parqueadero WHERE nit = ?";
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
                preparedStatement.setString(1, nit);

                int registrosEliminados = preparedStatement.executeUpdate();
                System.out.println("executeEliminado "+registrosEliminados);
                if (registrosEliminados > 0) {
                    respuesta = true;
                }
            } catch (SQLException e) {
                System.out.println("Error al eliminar el parqueadero: " + e.getMessage());
            }
        
        return respuesta;
    }    
    
    public boolean insertarParqueadero(String nit, String nombre, String direccion, String telefono){
        boolean respuesta = false;
        
        try {
            String consulta = "INSERT INTO parqueadero (nit, nombre, direccion, telefono) VALUES ('"+nit+"','"+nombre+"','"+direccion+"','"+telefono+"')";
            int resultado = this.manipularDB.executeUpdate(consulta);
            if (resultado==1) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error al insertar p: "+ex.getMessage());
        }
        
        return respuesta;
    }
    
    public boolean actualizarParqueadero(String nit, String nombre, String direccion, String telefono) {
        boolean respuesta = false;

        try {
            String consulta = "UPDATE parqueadero SET nombre = ?, direccion = ?, telefono = ? WHERE nit = ?";

            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, direccion);
            preparedStatement.setString(3, telefono);
            preparedStatement.setString(4, nit);

            int registrosActualizados = preparedStatement.executeUpdate();

            if (registrosActualizados > 0) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar el parqueadero: " + e.getMessage());
        }

        return respuesta;
    }
    
    public boolean verificarParqueadero(String nit) {
        try {
            String consulta = "SELECT * FROM parqueadero WHERE nit = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setString(1, nit);

            ResultSet parqueadero = preparedStatement.executeQuery();

            return parqueadero.next(); 
        } catch (SQLException ex) {
            System.out.println("Error en SELECT: " + ex.getMessage());
            return false; 
        }
    }
    
}
