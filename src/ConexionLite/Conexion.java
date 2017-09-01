 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionLite;

/**
 *
 * @author julioleyva
 */
import java.sql.*;
 
public class Conexion {
    public Connection connection = null;
    public ResultSet resultSet = null;
    public Statement statement = null;
    public String db= System.getProperty("user.dir") + "/Base.db";  

    public Conexion(){
   

    {
      try{
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:" + this.db );
         System.out.println("Conectado a la base de datos SQLite [ " + this.db + "]");
      }catch(Exception e){
         System.out.println(e);
         System.out.println("Conectado a la base de datos SQLite [ " + this.db + "]");
      }
 
    }
}
    
   
     
     
}