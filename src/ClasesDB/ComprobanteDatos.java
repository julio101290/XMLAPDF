/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDB;

import ConexionLite.Conexion;
import java.sql.PreparedStatement;

/**
 *
 * @author julioleyva
 */
public class ComprobanteDatos  extends Conexion {
    private String  strVersion;
    private String  strTotal;
    private String  strTipoComprobante;
    private String  strSubtotal;
    private String  strSerie;
    
    private String  strSello;
    private String  strNumCertificado;
    private String  strMetodoPago;
    private String  strFormaPago;
    private String  strFolio;
    
    private String  strFecha;
    private String  strDescuento;
    private String  strCondicionesPago;
    private String  strTipoCambio;
    private String  strNumCTAPago;
    
    private String  strMoneda;
    private String  strLugarExpedicion;
    private String  strUUID;

    public String getStrVersion() {
        return strVersion;
    }

    public void setStrVersion(String strVersion) {
        this.strVersion = strVersion;
    }

    public String getStrTotal() {
        return strTotal;
    }

    public void setStrTotal(String strTotal) {
        this.strTotal = strTotal;
    }

    public String getStrTipoComprobante() {
        return strTipoComprobante;
    }

    public void setStrTipoComprobante(String strTipoComprobante) {
        this.strTipoComprobante = strTipoComprobante;
    }

    public String getStrSubtotal() {
        return strSubtotal;
    }

    public void setStrSubtotal(String strSubtotal) {
        this.strSubtotal = strSubtotal;
    }

    public String getStrSerie() {
        return strSerie;
    }

    public void setStrSerie(String strSerie) {
        this.strSerie = strSerie;
    }

    public String getStrSello() {
        return strSello;
    }

    public void setStrSello(String strSello) {
        this.strSello = strSello;
    }

    public String getStrNumCertificado() {
        return strNumCertificado;
    }

    public void setStrNumCertificado(String strNumCertificado) {
        this.strNumCertificado = strNumCertificado;
    }

    public String getStrMetodoPago() {
        return strMetodoPago;
    }

    public void setStrMetodoPago(String strMetodoPago) {
        this.strMetodoPago = strMetodoPago;
    }

    public String getStrFormaPago() {
        return strFormaPago;
    }

    public void setStrFormaPago(String strFormaPago) {
        this.strFormaPago = strFormaPago;
    }

    public String getStrFolio() {
        return strFolio;
    }

    public void setStrFolio(String strFolio) {
        this.strFolio = strFolio;
    }

    public String getStrFecha() {
        return strFecha;
    }

    public void setStrFecha(String strFecha) {
        this.strFecha = strFecha;
    }

    public String getStrDescuento() {
        return strDescuento;
    }

    public void setStrDescuento(String strDescuento) {
        this.strDescuento = strDescuento;
    }

    public String getStrCondicionesPago() {
        return strCondicionesPago;
    }

    public void setStrCondicionesPago(String strCondicionesPago) {
        this.strCondicionesPago = strCondicionesPago;
    }

    public String getStrTipoCambio() {
        return strTipoCambio;
    }

    public void setStrTipoCambio(String strTipoCambio) {
        this.strTipoCambio = strTipoCambio;
    }

    public String getStrNumCTAPago() {
        return strNumCTAPago;
    }

    public void setStrNumCTAPago(String strNumCTAPago) {
        this.strNumCTAPago = strNumCTAPago;
    }

    public String getStrMoneda() {
        return strMoneda;
    }

    public void setStrMoneda(String strMoneda) {
        this.strMoneda = strMoneda;
    }

    public String getStrLugarExpedicion() {
        return strLugarExpedicion;
    }

    public void setStrLugarExpedicion(String strLugarExpedicion) {
        this.strLugarExpedicion = strLugarExpedicion;
    }

    public String getStrUUID() {
        return strUUID;
    }

    public void setStrUUID(String strUUID) {
        this.strUUID = strUUID;
    }
    
    
      public void  insertaComprobante()
    {
        //BORRANDO REGISTROS
        String q="delete from Comprobante";
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();

         }catch(Exception e){
            System.out.println(e);
    
        }
        
        q="delete from conceptos ";
        try {
            PreparedStatement pstm = connection.prepareStatement(q);
            pstm.execute();
            pstm.close();

         }catch(Exception e){
            System.out.println(e);
    
        }
        
         q="delete from ImpuestosDatos";
        try {
        PreparedStatement pstm = connection.prepareStatement(q);
        pstm.execute();
        pstm.close();
        }catch(Exception e){
           System.out.println(e);
        }
        
         q=" INSERT INTO  Comprobante ( "
                + "Version"
                + ",Total"
                + ",TipoComprobante"
                + ",SubTotal"
                + ",Serie"
                + ",Sello"
                + ",NoCertificado"
                + ",MetodoDePago"
                + ",FormaPago"
                + ",Folio"
                + ",fecha"
                + ",Descuento"
                + ",CondicionesDePago"
                + ",TipoCambio"
                + ",numCTAPago"
                + ",Moneda"
                + ",LugarExpedicion"
                + ",UUID )"
                + " VALUES ( "
                + "'"+this.getStrVersion()+"'"
                + ",'"+this.getStrTotal()+"' "
                + ",'"+this.getStrTipoComprobante()+"'"
                + ",'"+this.getStrSubtotal()+"'"
                + ",'"+this.getStrSerie()+"'"
                + ",'"+this.getStrSello()+"'"
               
                + ",'"+this.getStrNumCertificado()+"'"
                + ",'"+this.getStrMetodoPago()+"'"
                + ",'"+this.getStrFormaPago()+"'"
                
                + ",'"+this.getStrFolio()+"'"
                + ",'"+this.getStrFecha()+"'"
                + ",'"+this.getStrDescuento()+"'"
                + ",'"+this.getStrCondicionesPago()+"'"
                + ",'"+this.getStrTipoCambio()+"'"
                
                + ",'"+this.getStrNumCTAPago()+"'"
                + ",'"+this.getStrMoneda()+"'"
                + ",'"+this.getStrLugarExpedicion()+"'"   
                + ",'"+this.getStrUUID()+"')" ;
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
