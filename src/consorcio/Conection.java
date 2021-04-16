package consorcio;
import java.sql.*;

/**
 *
 * @author Leandro Asson
 */
public class Conection {
   
   //private final String url = "jdbc:mysql://192.168.1.15/oulton";
    private final String url = "jdbc:mysql://localhost/consorcio";
    PreparedStatement psPrepararSentencia;
    Connection con = null;

    
    public Conection()
    {
        try
        {  
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection(url,"LEOASSON","leo123");
            con = DriverManager.getConnection(url,"admin","administrador");
            if (con!=null)
            {
                System.out.println("Conexión a base de datos consorcio.");
            }
        }
         catch(SQLException | ClassNotFoundException e)
         {
         System.out.println(e);
         }
    }
    public Connection connected()
    {
      return con;
    }

    public void disconnect()
    {
      con = null;
      System.out.println("Fin de la conección");
    } 

    
}
