package ClasesDB; 
import ConexionLite.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author julioleyva Generacion Automatica
 */

public class EmisorDatos  extends Conexion {
    public String strRFC;
    public String strNombre;
    public String strPais;
    public String strNumeroExterior;
    public String strMunicipio;
    public String strLocalidad;
    public String strEstado;
    public String strCodigoPostal;
    public String strCalle;
    public String strColonia;
    public String strUUID;
    public String strRegimen;

    public void  insertaEmisor(){
    //BORRANDO REGISTROS
    String q="delete from Emisor";
    try {
        PreparedStatement pstm = connection.prepareStatement(q);
        pstm.execute();
        pstm.close();
        }catch(Exception e){
           System.out.println(e);
        }
       q=" INSERT INTO  Emisor ("
         +" RFC"
         +",Nombre"
         +",Pais"
         +",NumeroExterior"
         +",Municipio"
         +",Localidad"
         +",Estado"
         +",CodigoPostal"
         +",Calle"
         +",Colonia"
         +",UUID"
         +",Regimen"
         + " )VALUES ( "
         + " '"+strRFC + "' "
         + ", '"+strNombre + "' "
         + ", '"+strPais + "' "
         + ", '"+strNumeroExterior + "' "
         + ", '"+strMunicipio + "' "
         + ", '"+strLocalidad + "' "
         + ", '"+strEstado + "' "
         + ", '"+strCodigoPostal + "' "
         + ", '"+strCalle + "' "
         + ", '"+strColonia + "' "
         + ", '"+strUUID + "' "
         + ", '"+strRegimen + "' "
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