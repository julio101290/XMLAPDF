/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDB;
import ConexionLite.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julioleyva
 */
public class GenerarClase extends Conexion{
    
    public void  generarClase() throws SQLException{
        ResultSet result = null;
        String strClase="";
        String strTabla="ComplementoDatos";
        String strPaquete="ClasesDB";
        String nuevalinea = System.getProperty("line.separator");
        String q=" PRAGMA table_info("+strTabla+") ";
        
        strClase= "package "+strPaquete+"; "
                + nuevalinea + "import ConexionLite.Conexion;"
                + nuevalinea +"import java.sql.PreparedStatement;"
                + nuevalinea +"import java.sql.ResultSet;"
                + nuevalinea +"import java.sql.SQLException;"
                + nuevalinea +""
                + nuevalinea +"/**" 
                + nuevalinea +" *" 
                + nuevalinea +" * @author julioleyva Generacion Automatica" 
                + nuevalinea +" */"
                + nuevalinea +""
                + nuevalinea +"public class " + strTabla + "  extends Conexion {";
      
        //CREA VARIABLES
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            result = pstm.executeQuery();
            while (result.next()) {
                strClase= strClase+ nuevalinea+"    public String str"+ result.getString("name") +";";
            }
            pstm.close();
            
         }catch(Exception e){
            System.out.println(e);
         
        }
        
        //CREA FUNCION DE INSERCION
        strClase= strClase+ nuevalinea; 
        strClase= strClase+ nuevalinea+ "    public void  inserta" +strTabla +"(){";
        strClase= strClase+ nuevalinea+ "    //BORRANDO REGISTROS";
        strClase= strClase+ nuevalinea+ "    String q=\"delete from "+strTabla+"\";";
        strClase= strClase+ nuevalinea+ "    try {";
        strClase= strClase+ nuevalinea+ "        PreparedStatement pstm = connection.prepareStatement(q);";
        strClase= strClase+ nuevalinea+ "        pstm.execute();";
        strClase= strClase+ nuevalinea+ "        pstm.close();";
        strClase= strClase+ nuevalinea+ "        }catch(Exception e){";
        strClase= strClase+ nuevalinea+ "           System.out.println(e);";
        strClase= strClase+ nuevalinea+ "        }";
        strClase= strClase+ nuevalinea+ "       q=\" INSERT INTO  "+strTabla+" (\"";
        
        
        PreparedStatement pstm = connection.prepareStatement(q);
        result = pstm.executeQuery();
            while (result.next()) {
                if (result.getLong("cid")==0){   
                    strClase= strClase+ nuevalinea+"         +\" "+ result.getString("name") +"\"";
                    }
                else{
                    strClase= strClase+ nuevalinea+"         +\","+ result.getString("name") +"\"";
                }
            }
        pstm.close();    
        strClase= strClase+ nuevalinea+ "         + \" )VALUES ( \"";        
        
        PreparedStatement pstm2 = connection.prepareStatement(q);
        result = pstm2.executeQuery();
            while (result.next()) {
                if (result.getLong("cid")==0){   
                    strClase= strClase+ nuevalinea+"         + \" \'\"+str"+ result.getString("name") +" + \"\' \"";
                    }
                else{
                    strClase= strClase+ nuevalinea+"         + \", \'\"+str"+ result.getString("name") +" + \"\' \"";
                }
            }
        pstm.close();  

     
        strClase= strClase+ nuevalinea+ "        +\")\";";  
        strClase= strClase+ nuevalinea+ "        //se ejecuta la consulta"; 
        strClase= strClase+ nuevalinea+ "        try {"; 
        strClase= strClase+ nuevalinea+ "            PreparedStatement pstm = connection.prepareStatement(q);"; 
        strClase= strClase+ nuevalinea+ "            pstm.execute();"; 
        strClase= strClase+ nuevalinea+ "            pstm.close();"; 
        strClase= strClase+ nuevalinea+ "         }catch(Exception e){"; 
        strClase= strClase+ nuevalinea+ "            System.out.println(e);"; 
        strClase= strClase+ nuevalinea+ "        }"; 
        strClase= strClase+ nuevalinea+ "    }"; 
        strClase= strClase+ nuevalinea+ "}"; 
        
        System.out.print(strClase);   
    }
}
