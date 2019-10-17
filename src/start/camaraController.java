package start;

public class camaraController {

    public void camaraOpen(){
        Runtime aplicacion = Runtime.getRuntime();
        try{aplicacion.exec("cmd.exe /K  start microsoft.windows.camera:"); }
        catch(Exception e){System.out.println(e); }

    }

}
