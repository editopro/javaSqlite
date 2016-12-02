
package funcionalidad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Funcionalidad
{
    FileInputStream in;
    FileOutputStream out;
    File SeleccionarArchivo;
    
    
    public void salir()
    {
        System.exit(0);
    }
    
    public String Abrir(File SeleccionarArchivo)
    {
        String contenido = null;
        try{
            in = new FileInputStream(SeleccionarArchivo);
            int ascii;
            while((ascii = in.read())!=-1){
                char caracter = (char) ascii;
                contenido += caracter;
            }
        }
            catch(Exception ex){
                    System.err.println("Error"+ex);
                    }
            return contenido;
        }
    
    public String Guardar(File Archivoselec, String contenido){
        
        String respuesta=null;
            
            try{
                out = new FileOutputStream(Archivoselec);
                byte[]bytetext = contenido.getBytes();
                out.write(bytetext);
                respuesta="archivo guardado con exito";
            
            }catch(Exception ex){
                System.err.println("error"+ex);
             }
        
        
        return respuesta;
    }
}

