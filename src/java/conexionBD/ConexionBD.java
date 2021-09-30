
package conexionBD;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexionBD {
    //importar la clase Connection de mysql
    Connection cnx;
    //definimos las variables de aceso a la base de datos
    String url="jdbc:mysql://localhost/inventario";
    String usr="root";
    String pass="";
    
   public Connection ConexionBD()
   {
       try {
            Class.forName("com.mysql.jdbc.Driver");
           try {
               cnx = (Connection) DriverManager.getConnection(url,usr,pass);
           } catch (SQLException ex) {
               Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
           }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);

        }
        return cnx;
   }
}
