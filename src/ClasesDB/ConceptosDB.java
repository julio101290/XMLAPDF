/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDB;
import ConexionLite.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author julioleyva
 */
public class ConceptosDB  extends Conexion{
    private String  noIdenticacion;
    private String  Descripcion;
    private Double  Importe;
    private Double  Cantidad;
    private String  Unidad;
    private Double  valorUnitarioM;
    private String  UUID;      

    public Double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
                                                                           
    
    
    

    public String getNoIdenticacion() {
        return noIdenticacion;
    }

    public void setNoIdenticacion(String noIdenticacion) {
        this.noIdenticacion = noIdenticacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Double getImporte() {
        return Importe;
    }

    public void setImporte(Double Importe) {
        this.Importe = Importe;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String Unidad) {
        this.Unidad = Unidad;
    }

    public Double getValorUnitarioM() {
        return valorUnitarioM;
    }

    public void setValorUnitarioM(Double valorUnitarioM) {
        this.valorUnitarioM = valorUnitarioM;
    }

    
      public void  insertaConceptos()
    {
                //BORRANDO REGISTROS
        String q="";
   
        
         q=" INSERT INTO  conceptos ( "
                + "NoIdentificacion"
                + ",Descripcion"
                + ",Importe"
                + ",Unidad"
                + ",ValorUnitario "
                + ",UUID"
                + ",Cantidad) VALUES ( "
                + "'"+this.noIdenticacion+"'"
                + ",'"+this.Descripcion+"' "
                + ","+this.Importe+""
                + ",'"+this.Unidad+"'"
                + ","+this.valorUnitarioM
                + ",'"+this.UUID+"'"
                + ","+this.Cantidad+")" ;
        //se ejecuta la consulta
        q= q.replace("null", "");
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();
       
            
         }catch(Exception e){
            System.out.println(e);
    
        }
    }}