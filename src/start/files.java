package start;

import sun.rmi.runtime.Log;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.*;

public class files {




    public void CreateFile(String path, String fileName, String contenido) {
        try {

            File file = new File(path +"/"+ fileName);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveFiles(String path,String pathC,String fileName) throws IOException {

        Path FROM = Paths.get(path+"/"+fileName);
        Path TO = Paths.get(pathC+fileName);
        //sobreescribir el fichero de destino, si existe, y copiar
        // los atributos, incluyendo los permisos rwx
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        Files.copy(FROM, TO, options);

    }



////---------------------------metodo de borrado--------------------------------------------------------------

    public void deleteDirectory(String path){

        File directory = new File(path);

        //make sure directory exists
        if(!directory.exists()){

            System.out.println("Directory no existe.");

        }else{

            try{

                delete(directory);

            }catch(IOException e){
                e.printStackTrace();
                //  System.exit(0);
            }
        }

        System.out.println("Borrado");
    }

    public static void delete(File file)
            throws IOException{

        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                System.out.println("Directory Vacio : "
                        + file.getAbsolutePath());

            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    delete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    // file.delete();
                    System.out.println("Directory Vacio: "
                            + file.getAbsolutePath());
                }
            }

        }else{
            //if file, then delete it
            file.delete();
            System.out.println("Archivo borrado  : " + file.getAbsolutePath());
        }



    }



//-----------------------------------------------------------------------------------CAMARA ABRIR-----------------------------------------



    public int checkTask(){
        try{
            String maia="WindowsCamera";
            String str_proceso = null;
            String admin =
                    System.getenv("windir") + "\\system32\\" + "tasklist.exe";
            Process proceso = Runtime.getRuntime().exec(admin);
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));
            int i=0;
            while((str_proceso = input.readLine()) != null){
                //   System.out.println(str_proceso); //Todos los procesos

                if(i>4){
                    String palabratask = str_proceso.substring(0,13);
                    if (maia.equals(palabratask)){
                      //System.out.println(str_proceso);
                        System.out.println("Abierto");
                        return 1;
                    }
                }
                i++;
            }
            input.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Cerrado");
        return 0;
    }





    public int CheckDirectory(String path,int control){
        File directory = new File(path);
        //make sure directory exists
        if(!directory.exists()){

            System.out.println("Directory no existe.");
            // System.exit(0);
            return 0;

        }else{

            try{

                control=comprobar(directory,control);
                System.out.println(control);

                return control;
            }catch(IOException e){
                e.printStackTrace();
                //  System.exit(0);
            }
        }

        System.out.println("Done");
        return 0;
    }



    public static int comprobar(File file,int control)
            throws IOException{

        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                // file.delete();
                System.out.println("Directory Vacio : "
                        + file.getAbsolutePath());
                return 0;

            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete  MOVER colocar aqui
                    //  delete(fileDelete);
                    return 1;
                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    // file.delete();
                    System.out.println("Directory vacio : "
                            + file.getAbsolutePath());
                    return 0;
                }
            }

        }else{
            //if file, then delete it
            file.delete();
            System.out.println("File is deleted : " + file.getAbsolutePath());
            return 0;
        }

        return 0;

    }




    public void moverDirectory(String path,String pathC){

        File directory = new File(path);

        //make sure directory exists
        if(!directory.exists()){
            System.out.println("Directory no existe.");


        }else{

            try{

                mover(directory,path,pathC);

            }catch(IOException e){
                e.printStackTrace();
            }
        }

        System.out.println("Movido");
    }



    public static void mover(File file,String path, String pathC)
            throws IOException{

        if(file.isDirectory()){

            //directory is empty, then delete it
            if(file.list().length==0){

                System.out.println("Directory vacio MOVER : "
                        + file.getAbsolutePath());

            }else{

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    System.out.println(temp+" NOMBRE");
                    File fileMove = new File(file, temp);
                    Path FROM = Paths.get(path+"/"+temp);
                    Path TO = Paths.get(pathC+temp);
                    //sobreescribir el fichero de destino, si existe, y copiar
                    // los atributos, incluyendo los permisos rwx
                    CopyOption[] options = new CopyOption[]{
                            StandardCopyOption.REPLACE_EXISTING,
                            StandardCopyOption.COPY_ATTRIBUTES
                    };
                    Files.copy(FROM, TO, options);

                }

                //check the directory again, if empty then delete it
                if(file.list().length==0){
                    System.out.println("Directory vacio MOVER : "
                            + file.getAbsolutePath());
                }
            }

        }else{
            //if file, then delete it
            System.out.println("Archivo movido : " + file.getAbsolutePath());
        }

    }



    public void deleteDesktopIni(String path) {

        File fichero = new File(path+"\\desktop.ini");

        if (fichero.delete())
            System.out.println("El desktop.ini ha sido borrado satisfactoriamente");
        else
            System.out.println("El desktop.ini no pudó ser borrado");
    }


}
