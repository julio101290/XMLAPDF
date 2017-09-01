/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

import ClasesComprobante.Comprobante;
import ClasesDB.ComplementoDatos;
import ClasesDB.ComprobanteDatos;
import ClasesDB.ConceptosDB;
import ClasesDB.EmisorDatos;
import ClasesDB.GeneraQR;
import ClasesDB.ImpuestosDatos;
import ClasesDB.LugarExpedicionDatos;
import ClasesDB.ReceptorDatos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author julioleyva
 */
public class classXML {
   
    public static void leeXML(String strRutaArchivo) throws FileNotFoundException, IOException {
      
        JAXBContext factura;
        ConceptosDB concepto = new ConceptosDB();
        ComprobanteDatos Comp =new ComprobanteDatos();
        EmisorDatos datosEmisor = new EmisorDatos();
        ReceptorDatos ReceptorD = new ReceptorDatos();
        ImpuestosDatos Im = new ImpuestosDatos();
        LugarExpedicionDatos lugarExpedicion= new LugarExpedicionDatos();
        classHerramientas a = new classHerramientas();
        ComplementoDatos ComplementoD = new ComplementoDatos();
        
        
        try {
            factura= JAXBContext.newInstance(Comprobante.class);
             Unmarshaller u = factura.createUnmarshaller();
    
            Comprobante root = (Comprobante) u.unmarshal(new FileInputStream(strRutaArchivo));
            frmPrincipal.lblProceso.setText("LEYENDO DATOS GENERALES DEL COMPROBANTE");
        
            //INSERTA DATOS GENERALES DEL COMPROBANTE
            try{
                Comp.setStrVersion(root.getVersion().toString());
                Comp.setStrSubtotal(classHerramientas.strDevuelveAtributo(strRutaArchivo, "subTotal"));
                Comp.setStrTipoComprobante(root.getTipoDeComprobante().toString() );
                Comp.setStrSerie(String.valueOf(root.getSerie()));
                Comp.setStrSello(root.getSello().toString());
                Comp.setStrNumCertificado(root.getNoCertificado());
                Comp.setStrMetodoPago(root.getMetodoDePago().toString());
                Comp.setStrFormaPago(root.getFormaDePago().toString());
                Comp.setStrFolio(root.getFolio().toString());
                Comp.setStrFecha(root.getFecha().toString());
                Comp.setStrDescuento(String.valueOf(root.getDescuento()));
                Comp.setStrCondicionesPago(String.valueOf(root.getCondicionesDePago()));
                Comp.setStrTipoCambio(String.valueOf(root.getTipoCambio()));
                Comp.setStrNumCTAPago(String.valueOf(root.getNumCtaPago()));
                Comp.setStrMoneda(String.valueOf(root.getMoneda()));
                Comp.setStrLugarExpedicion(String.valueOf(root.getLugarExpedicion()));
                Comp.setStrUUID(classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID"));
                Comp.setStrTotal(root.getTotal().toString());
                Comp.insertaComprobante();
            }
             catch(Exception comp) { 
                 frmPrincipal.lblProceso.setText("ERROR AL LEER DATOS DEL COMPROBANTE");
             }
            frmPrincipal.lblProceso.setText("LEYENDO DATOS GENERALES DEL EMISOR");
            frmPrincipal.lblProceso.setFocusable(true);
            // INSERTA DATOS EMISOR
            try{
                datosEmisor.strRFC= String.valueOf((root.getEmisor().getRfc()));
                datosEmisor.strNombre= String.valueOf((root.getEmisor().getNombre()));
                datosEmisor.strCalle= String.valueOf((root.getEmisor().getDomicilioFiscal().getCalle()));
                datosEmisor.strCodigoPostal= (String.valueOf(root.getEmisor().getDomicilioFiscal().getCodigoPostal()));
                datosEmisor.strColonia= String.valueOf((root.getEmisor().getDomicilioFiscal().getColonia()));
                datosEmisor.strEstado= String.valueOf((root.getEmisor().getDomicilioFiscal().getEstado()));
                datosEmisor.strLocalidad= (root.getEmisor().getDomicilioFiscal().getLocalidad());
                datosEmisor.strMunicipio= (root.getEmisor().getDomicilioFiscal().getMunicipio());
                datosEmisor.strNumeroExterior= String.valueOf((root.getEmisor().getDomicilioFiscal().getNoExterior()));
                datosEmisor.strPais= String.valueOf((root.getEmisor().getDomicilioFiscal().getPais()));
                datosEmisor.strRegimen= String.valueOf((root.getEmisor().getRegimenFiscal().get(0).getRegimen()));
                datosEmisor.strUUID= classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID");
                datosEmisor.insertaEmisor();

                frmPrincipal.BarraProceso.setValue(40);
            }
            catch (Exception emisor){
                frmPrincipal.lblProceso.setText("ERROR AL LEER DATOS DEL EMISOR");
            }
            //INSERTA LUGAR DE EXPEDICION
            try{ 
            lugarExpedicion.strCalleExpedidoEn=String.valueOf(root.getEmisor().getExpedidoEn().getCalle());
            lugarExpedicion.strCodigoPostalExpedidoEn=String.valueOf(root.getEmisor().getExpedidoEn().getCodigoPostal());
            lugarExpedicion.strColoniaExpedidoEn=String.valueOf(root.getEmisor().getExpedidoEn().getColonia());
            lugarExpedicion.strEstadoExpedidoEn=String.valueOf(root.getEmisor().getExpedidoEn().getEstado());
            lugarExpedicion.strLocalidadExpedidoEn=String.valueOf(root.getEmisor().getExpedidoEn().getLocalidad());
            lugarExpedicion.strMunicipioExpedicion=String.valueOf(root.getEmisor().getExpedidoEn().getMunicipio());
            lugarExpedicion.strNumeroInteriorExpedicion=String.valueOf(root.getEmisor().getExpedidoEn().getNoInterior());
            lugarExpedicion.strNumeroExteriorExpedicion=String.valueOf(root.getEmisor().getExpedidoEn().getNoExterior());
            lugarExpedicion.strPaisExpedicion=String.valueOf(root.getEmisor().getExpedidoEn().getPais());
            lugarExpedicion.strReferenciaExpedicion=String.valueOf(root.getEmisor().getExpedidoEn().getReferencia());
            lugarExpedicion.strUUID=classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID");
            lugarExpedicion.insertaLugarExpedicionDatos();
            }
            catch(Exception exe) { 
                   lugarExpedicion.strCalleExpedidoEn=String.valueOf(root.getLugarExpedicion());
                   lugarExpedicion.strUUID=classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID");
                   lugarExpedicion.insertaLugarExpedicionDatos();
            }

            frmPrincipal.BarraProceso.setValue(50);
            //INSERTA DATOS RECEPTOR
            try{
                ReceptorD.strCalle =String.valueOf(root.getReceptor().getDomicilio().getCalle());
                ReceptorD.strCodigoPostal =String.valueOf(root.getReceptor().getDomicilio().getCodigoPostal());
                ReceptorD.strColonia =String.valueOf(root.getReceptor().getDomicilio().getColonia());
                ReceptorD.strEstado =String.valueOf(root.getReceptor().getDomicilio().getEstado());
                ReceptorD.strLocalidad =String.valueOf(root.getReceptor().getDomicilio().getLocalidad());
                ReceptorD.strMunicipio =String.valueOf(root.getReceptor().getDomicilio().getMunicipio());
                ReceptorD.strNoExterior =String.valueOf(root.getReceptor().getDomicilio().getNoExterior());
                ReceptorD.strNoInterior =String.valueOf(root.getReceptor().getDomicilio().getNoInterior());
                ReceptorD.strNombre =String.valueOf(root.getReceptor().getNombre());
                ReceptorD.strPais =String.valueOf(root.getReceptor().getDomicilio().getPais());
                ReceptorD.strRFCReceptor =String.valueOf(root.getReceptor().getRfc());
                ReceptorD.strUUID =classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID");
                ReceptorD.insertaReceptorDatos();
            }
            catch(Exception receptor){
                 frmPrincipal.lblProceso.setText("ERROR AL LEER DATOS DEL RECEPTOR");
            }

            frmPrincipal.BarraProceso.setValue(70);
            //GENERA CODIGO QR
            GeneraQR.generaQR(String.valueOf((root.getEmisor().getRfc())), String.valueOf(root.getReceptor().getRfc()),classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID"),root.getTotal().toString());

            frmPrincipal.BarraProceso.setValue(80);
            //INSERTA IMPUESTOS TRASLADADOS
           try{
            for (int x=0; x<root.getImpuestos().getTraslados().getTraslado().size(); x++){
                Im.strImporte = String.valueOf(root.getImpuestos().getTraslados().getTraslado().get(x).getImporte());
                Im.strImpuesto = String.valueOf(root.getImpuestos().getTraslados().getTraslado().get(x).getImpuesto());
                Im.strTasa = String.valueOf(root.getImpuestos().getTraslados().getTraslado().get(x).getTasa());
                Im.strUUID = classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID");
                Im.insertaImpuestosDatos();
            }
           }catch(Exception exe1) {
               Im.strImporte = "0";
               Im.strImpuesto = "IVA";
               Im.strTasa ="16";
               Im.strUUID = classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID");
               Im.insertaImpuestosDatos();
           }

            frmPrincipal.BarraProceso.setValue(90);
            //DATOS COMPLEMENTO
           try{
                ComplementoD.strNoCertificadoSAT = classHerramientas.strDevuelveAtributo(strRutaArchivo, "noCertificadoSAT");
                ComplementoD.strSelloCFD = classHerramientas.strDevuelveAtributo(strRutaArchivo, "selloCFD");
                ComplementoD.strSelloSAt = classHerramientas.strDevuelveAtributo(strRutaArchivo, "selloSAT");
                ComplementoD.strUUID = classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID");
                ComplementoD.strFechaTimbrado= classHerramientas.strDevuelveAtributo(strRutaArchivo, "FechaTimbrado");
                ComplementoD.strRutaQR=System.getProperty("user.dir") + "/QR_Code.JPG";

                try{
                    ComplementoD.strCantidadLetra=classHerramientas.readNumber(root.getTotal().toString(), ".", root.getMoneda());
                }
                catch(Exception exp){
                    ComplementoD.strCantidadLetra=classHerramientas.readNumber(root.getTotal().toString(), ".", "PESOS");
                }
                ComplementoD.insertaComplementoDatos();
           }
            catch(Exception complemento){
                     frmPrincipal.lblProceso.setText("ERROR AL LEER DATOS DEL COMPLEMENTO");
                    }
            frmPrincipal.BarraProceso.setValue(100);
            //INSERTA DATOS DE LOS PRODUCTOS VENDIDOS

                for(int x=0; x<root.getConceptos().getConcepto().size(); x++){
                    concepto.setCantidad(Double.valueOf(root.getConceptos().getConcepto().get(x).getCantidad().toString()));
                    concepto.setDescripcion(root.getConceptos().getConcepto().get(x).getDescripcion());
                    concepto.setImporte(Double.valueOf(root.getConceptos().getConcepto().get(x).getImporte().toString()));
                    concepto.setUnidad(root.getConceptos().getConcepto().get(x).getUnidad());
                    concepto.setValorUnitarioM(Double.valueOf(root.getConceptos().getConcepto().get(x).getValorUnitario().toString()));
                    concepto.setUUID(classHerramientas.strDevuelveAtributo(strRutaArchivo, "UUID"));
                    concepto.setNoIdenticacion(String.valueOf(root.getConceptos().getConcepto().get(x).getNoIdentificacion()));
                    concepto.insertaConceptos();

                    Comprobante.Complemento complemento=root.getComplemento();
                }
            }

    
        
    catch (Exception exw123) {
                frmPrincipal.lblProceso.setText("CFDI MAL FORMADO");
            }
        }

}

