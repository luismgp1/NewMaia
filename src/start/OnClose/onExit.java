package start.OnClose;

import start.camaraController;
import start.files;

public class onExit {




    public void CloseCamera(String path,String pathC,String pathP){

        files file = new files();
        camaraController cam =new camaraController();


        file.deleteDirectory(path); ///Inicio y borrado de las fotos existentes

        int controlExit;
        do{

            controlExit=file.checkTask(); /// comprobar que la aplicacion este abierta

        }while(controlExit==1);

        int controlFolder=0;
        controlFolder=file.CheckDirectory(path,controlFolder); //comprobar si el directorio tiene fotos o esta vacio

        if (controlFolder==1){ //contiene fotos
            System.out.println("con fotos");
            file.deleteDesktopIni(path);
            file.moverDirectory(path,pathC);
            file.deleteDirectory(path);
            cam.reCopiado(path,pathP); ///RECOPIADO

            System.exit(0);
        }

        if (controlFolder==0){ //no contiene fotos
            System.out.println("sin fotos");
            cam.reCopiado(path,pathP);  //RECOPIADO
            System.exit(1);
        }

    }

}
