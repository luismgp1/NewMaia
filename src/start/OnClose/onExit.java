package start.OnClose;

import start.files;

public class onExit {

    public void CloseCamera(String path,String pathC){
        files file = new files();
        file.deleteDirectory(path);

        int controlExit=1;
        do{

            controlExit=file.checkTask();

        }while(controlExit==1);

        int controlFolder=0;

        controlFolder=file.CheckDirectory(path,controlFolder);

        if (controlFolder==1){
            System.out.println("con fotos");
            file.deleteDesktopIni(path);
            file.moverDirectory(path,pathC);
            file.deleteDirectory(path);
            System.exit(0);
        }

        if (controlFolder==0){
            System.out.println("sin fotos");
            System.exit(1);
        }

    }

}
