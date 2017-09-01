package ClasesDB; 
import ConexionLite.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julioleyva Generacion Automatica
 */

public class ImpuestosDatos  extends Conexion {
    public String strImporte;
    public String strImpuesto;
    public String strTasa;
    public String strUUID;

    public void  insertaImpuestosDatos(){

    String q="";

       q=" INSERT INTO  ImpuestosDatos ("
         +" Importe"
         +",Impuesto"
         +",Tasa"
         +",UUID"
         + " )VALUES ( "
         + " '"+strImporte + "' "
         + ", '"+strImpuesto + "' "
         + ", '"+strTasa + "' "
         + ", '"+strUUID + "' "
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