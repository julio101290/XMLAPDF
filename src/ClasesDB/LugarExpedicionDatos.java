package ClasesDB; 
import ConexionLite.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julioleyva Generacion Automatica
 */

public class LugarExpedicionDatos  extends Conexion {
    public String strPaisExpedicion;
    public String strNumeroInteriorExpedicion;
    public String strMunicipioExpedicion;
    public String strLocalidadExpedidoEn;
    public String strEstadoExpedidoEn;
    public String strCodigoPostalExpedidoEn;
    public String strCalleExpedidoEn;
    public String strColoniaExpedidoEn;
    public String strUUID;
    public String strNumeroExteriorExpedicion;
    public String strReferenciaExpedicion;

    public void  insertaLugarExpedicionDatos(){
    //BORRANDO REGISTROS
    String q="delete from LugarExpedicionDatos";
    try {
        PreparedStatement pstm = connection.prepareStatement(q);
        pstm.execute();
        pstm.close();
        }catch(Exception e){
           System.out.println(e);
        }
       q=" INSERT INTO  LugarExpedicionDatos ("
         +" PaisExpedicion"
         +",NumeroInteriorExpedicion"
         +",MunicipioExpedicion"
         +",LocalidadExpedidoEn"
         +",EstadoExpedidoEn"
         +",CodigoPostalExpedidoEn"
         +",CalleExpedidoEn"
         +",ColoniaExpedidoEn"
         +",UUID"
         +",NumeroExteriorExpedicion"
         +",ReferenciaExpedicion"
         + " )VALUES ( "
         + " '"+strPaisExpedicion + "' "
         + ", '"+strNumeroInteriorExpedicion + "' "
         + ", '"+strMunicipioExpedicion + "' "
         + ", '"+strLocalidadExpedidoEn + "' "
         + ", '"+strEstadoExpedidoEn + "' "
         + ", '"+strCodigoPostalExpedidoEn + "' "
         + ", '"+strCalleExpedidoEn + "' "
         + ", '"+strColoniaExpedidoEn + "' "
         + ", '"+strUUID + "' "
         + ", '"+strNumeroExteriorExpedicion + "' "
         + ", '"+strReferenciaExpedicion + "' "
        +")";
        //se ejecuta la consulta
        q= q.replace("null", "");
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();
         }catch(Exception e){
            System.out.println(e);
        }
    }
}