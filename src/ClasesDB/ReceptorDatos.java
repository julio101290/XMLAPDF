package ClasesDB; 
import ConexionLite.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julioleyva Generacion Automatica
 */

public class ReceptorDatos  extends Conexion {
    public String strRFCReceptor;
    public String strNombre;
    public String strPais;
    public String strNoExterior;
    public String strNoInterior;
    public String strMunicipio;
    public String strLocalidad;
    public String strEstado;
    public String strCodigoPostal;
    public String strCalle;
    public String strColonia;
    public String strUUID;

    public void  insertaReceptorDatos(){
    //BORRANDO REGISTROS
    String q="delete from ReceptorDatos";
    try {
        PreparedStatement pstm = connection.prepareStatement(q);
        pstm.execute();
        pstm.close();
        }catch(Exception e){
           System.out.println(e);
        }
       q=" INSERT INTO  ReceptorDatos ("
         +" RFCReceptor"
         +",Nombre"
         +",Pais"
         +",NoExterior"
         +",NoInterior"
         +",Municipio"
         +",Localidad"
         +",Estado"
         +",CodigoPostal"
         +",Calle"
         +",Colonia"
         +",UUID"
         + " )VALUES ( "
         + " '"+strRFCReceptor + "' "
         + ", '"+strNombre + "' "
         + ", '"+strPais + "' "
         + ", '"+strNoExterior + "' "
         + ", '"+strNoInterior + "' "
         + ", '"+strMunicipio + "' "
         + ", '"+strLocalidad + "' "
         + ", '"+strEstado + "' "
         + ", '"+strCodigoPostal + "' "
         + ", '"+strCalle + "' "
         + ", '"+strColonia + "' "
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