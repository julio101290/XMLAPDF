package ClasesDB; 
import ConexionLite.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julioleyva Generacion Automatica
 */

public class ComplementoDatos  extends Conexion {
    public String strSelloSAt;
    public String strSelloCFD;
    public String strNoCertificadoSAT;
    public String strUUID;
    public String strFechaTimbrado;
    public String strRutaQR;
    public String strCantidadLetra;

    public void  insertaComplementoDatos(){
    //BORRANDO REGISTROS
    String q="delete from ComplementoDatos";
    try {
        PreparedStatement pstm = connection.prepareStatement(q);
        pstm.execute();
        pstm.close();
        }catch(Exception e){
           System.out.println(e);
        }
       q=" INSERT INTO  ComplementoDatos ("
         +" SelloSAt"
         +",SelloCFD"
         +",NoCertificadoSAT"
         +",UUID"
         +",FechaTimbrado"
         +",RutaQR"
         +",CantidadLetra"
         + " )VALUES ( "
         + " '"+strSelloSAt + "' "
         + ", '"+strSelloCFD + "' "
         + ", '"+strNoCertificadoSAT + "' "
         + ", '"+strUUID + "' "
         + ", '"+strFechaTimbrado + "' "
         + ", '"+strRutaQR + "' "
         + ", '"+strCantidadLetra + "' "
        +")";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();
         }catch(Exception e){
            System.out.println(e);
        }
    }
}