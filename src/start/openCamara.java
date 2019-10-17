package start;


import start.OnClose.onExit;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;

public class openCamara {

    private static void createAndShowGUI() {

        JFrame frame = new JFrame("titulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("APP OPEN");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        String path= FileSystemView.getFileSystemView().getDefaultDirectory().getPath(); path=path.replaceAll("Documents","Pictures"); path=path+"\\Camera Roll";
        String pathC="C:\\CAM\\";

/*
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        }); */


        camaraController camara = new camaraController();
        camara.camaraOpen();

        try {
            Thread.sleep(2000);
            onExit process = new onExit();
            process.CloseCamera(path,pathC);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}

