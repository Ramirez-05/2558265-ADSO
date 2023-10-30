
package PackagesDB;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Personas extends DataBase {
    
    
     public ResultSet listaPeronas(){
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
    
}


