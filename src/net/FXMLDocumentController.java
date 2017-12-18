/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net;

import static com.sun.deploy.net.protocol.ProtocolType.HTTP;
import static com.sun.deploy.trace.TraceLevel.UI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.net.Proxy.Type.HTTP;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author kristhian
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField ip_Handler;
    @FXML
    private Button Button;
    @FXML
    private TextField ip_hosts;
    @FXML
    private TextField get_keepalive;
    @FXML
    private TextField Channel_View;
    @FXML
    private TextField time_ran;
    @FXML
    private TextField Socket_Host;
    @FXML
    private TextField Socket_Port;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void c(MouseEvent event) throws IOException {
       Socket s = new Socket(Socket_Host.getText(), Integer.parseInt(Socket_Port.getText()));
       ip_Handler.setText(s.getLocalAddress().toString()+":"+s.getLocalPort());
       ip_hosts.setText(s.getInetAddress().toString()+":"+s.getPort());
       if(s.getKeepAlive() == true){get_keepalive.setText("You are Ofline!");}
       if(s.getKeepAlive() == false){get_keepalive.setText("You are Online!");}
       else get_keepalive.setText("Error!");
       if(s.getChannel()==null){Channel_View.setText("Could not find channel from host!");}
       else Channel_View.setText("Channel: "+s.getChannel());
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
       Date date = new Date();
       time_ran.setText(dateFormat.format(date));
    }

    @FXML
    private void handleButtonAction(MouseEvent event) {
        Socket_Host.setText("");
        Socket_Port.setText("");
        ip_Handler.setText("");
        ip_hosts.setText("");
        get_keepalive.setText("");
        Channel_View.setText("");
        time_ran.setText("");
    }
//Responsable for saving to a file the shown report.
    @FXML
    private void onSave(MouseEvent event) throws IOException,RuntimeException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Socket s = new Socket(Socket_Host.getText(), Integer.parseInt(Socket_Port.getText()));
         BufferedWriter writer = new BufferedWriter(new FileWriter("NetworkReport.csv"));
         writer.write("Report, created on: , "+dateFormat.format(date));
         writer.write("\n");
         writer.write(s.getLocalAddress().toString()+","+s.getLocalPort());
        writer.write("\n");
        writer.write(s.getInetAddress().toString()+","+s.getPort());
        writer.write("\n");
       if(s.getKeepAlive() == true){writer.write("Connection, Status , You are Ofline!");}
       if(s.getKeepAlive() == false){writer.write("Connection, Status , You are Online!");}
       else writer.write("Connection Status , Error!");
       writer.write("\n");
       if(s.getChannel()==null){writer.write("Could not, find chan,nel, from host!");}
       else writer.write("Channel:, "+s.getChannel());
       writer.write("\n");
       writer.close();
        Frame frame = new Frame();
        UIManager UI=new UIManager();
        UI.put("OptionPane.background",new ColorUIResource(255,0,0));
        UI.put("Panel.background",new ColorUIResource(0,0,0));
        UI.put("OptionPane.messageForeground", Color.blue);
        JOptionPane.showMessageDialog(frame,
        "File Save SUCCESSFUL!",
        "Save Complete",
        JOptionPane.PLAIN_MESSAGE);
        System.exit(-1);
    }

}