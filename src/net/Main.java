/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import java.awt.Color;
import java.awt.Frame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author kristhian
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        Frame frame = new Frame();
        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(255,0,0));
        UI.put("Panel.background",new ColorUIResource(0,0,0));
        UI.put("OptionPane.messageForeground", Color.blue);
        JOptionPane.showMessageDialog(frame,
        "This program is an example of how powerful Java Socket programming can be.\nEnter you Modem, or Server Socket IP Address, and Port. You will see a fiew ways you can implement Sockets.\nThis is an example and is not met to be sold, or distributed to anyone with malicious intentions. \nThanks for using Network Status Viewer.\n",
        "Instructions!",
        JOptionPane.PLAIN_MESSAGE);
    }
    
}
