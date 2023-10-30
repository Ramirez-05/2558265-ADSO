
package Clases;

import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataAccessException;


public class ToolsApi {
    
     
    public static Map<String, Object> createMaps(boolean status, String mensaje){
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", mensaje);
        return response;
    }
    
    public static Map<String, Object> createMaps(boolean status, String mensaje, DataAccessException e){
        Map<String, Object> response = new HashMap<>();
        response.put("status", status);
        response.put("message", mensaje);
        response.put("exception", e.getMessage());
        return response;
    }
    
}
