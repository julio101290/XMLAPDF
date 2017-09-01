/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leerxml;

import java.io.File;
import javax.swing.JOptionPane;

import java.util.Map;
import java.util.HashMap;
import ConexionLite.Conexion;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author julio
 */
public class Reportes {
    File theFile ;
    public static String MENSAJE="";
   
    //http://www.javamexico.org/foros/java_standard_edition/como_llamar_un_reporte
    public static void lanzarReporte(String strConsulta ,String strReporte)
            {
                Conexion con;
                con = new Conexion();
               
                Map mpParametros = new HashMap();
        
                mpParametros.put("SUBREPORT_DIR", System.getProperty("user.dir") +("/src/ClasesDB/"));
                mpParametros.put("SQL", "Select Impuesto,tasa,importe from ImpuestosDatos");
                try
                {  

                    String fileName = System.getProperty("user.dir").concat("/src/ClasesDB/"+strReporte+".jrxml");
                   

                    if (fileName == null)
                    {                
                        System.out.println("No encuentro el archivo del reporte.");
                        System.exit(2);
                    }
                        
                  
                   
                File theFile = new File(fileName);
                
                if(theFile.exists()==false){
                    System.out.println("No encuentro el archivo del reporte.");
                    JOptionPane.showInternalMessageDialog(null,"No se encontro el archivo de reporte");
                    return;
                }
                
                JRDesignQuery newQuery = new JRDesignQuery();
                JasperDesign jasperDesign = JRXmlLoader.load(theFile);
                newQuery.setText(strConsulta);
                jasperDesign.setQuery(newQuery);
                
               
                //jasperDesign.
               
                 JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
                 System.out.println(strConsulta);
       
                 JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, mpParametros, con.connection);
           
                 //    jasperPrint = JasperFillManager.fillReport(jasperReport, mpParametros,new JREmptyDataSource() );
                 JasperViewer jviewer = new JasperViewer(jasperPrint,false);
                 jviewer.setTitle(strReporte);
                 jviewer.setVisible(true);
                   //con.desconectar();
                }

                catch (Exception j)
                {
                    System.out.println("Mensaje de Error:"+j.getMessage());
                    MENSAJE=    "Mensaje de Error:"+j.getMessage();    
//JOptionPane.show(null,"Mensaje de Error:"+j.getMessage().toString());
                }
               
            }


              
               
            }
           
            


    

