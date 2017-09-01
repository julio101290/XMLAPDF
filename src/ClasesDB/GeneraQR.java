/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDB;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


/**
 *
 * @author julioc
 */
public class GeneraQR {
    public static void generaQR(String strRFCEmisor,String strRFCReceptor,String strUUID,String strImporte){
        String strTexto="re="+strRFCEmisor + "&rr="+strRFCReceptor+"&tt="+strImporte+"&id"+strUUID;
        System.out.println(strTexto);
        ByteArrayOutputStream out = QRCode.from(strTexto).to(ImageType.PNG).stream();
		try {
			FileOutputStream fout = new FileOutputStream(new File(
					System.getProperty("user.dir") + "/QR_Code.JPG"));

			fout.write(out.toByteArray());

			fout.flush();
			fout.close();

		} catch (FileNotFoundException e) {
			// Do Logging
		} catch (IOException e) {
			// Do Logging
		}
	
    }
            
    

}
