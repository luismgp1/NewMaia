package start;

import java.io.File;

public class camaraController {

    public void camaraOpen(){
        Runtime aplicacion = Runtime.getRuntime();
        try{aplicacion.exec("cmd.exe /K  start microsoft.windows.camera:"); }
        catch(Exception e){System.out.println(e); }
    }


    public void onOpen(String path,String pathP){
        File directorio=new File(pathP);
        directorio.mkdir();
        pathP=pathP+"\\";
        files file = new files();
        System.out.println(path);
        System.out.println(pathP);
        file.moverDirectory(path,pathP);
        file.deleteDirectory(path);
    }

    public void reCopiado(String path,String pathP){

        files file = new files();
        System.out.println(path);
        System.out.println(pathP);
        file.moverDirectory(pathP,path+"\\");
        file.deleteDirectory(pathP);
    }






}
