package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.omg.CORBA.DataInputStream;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientApp {
    final int Port = 8007;
    public TextArea txtAreaMsg;
    public TextField txtMsg;
    public Button btnSent;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    public void initialize() {
        try {
            socket=new Socket("localhost",Port);
            System.out.println("Accept Client..!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnSentOnAction(ActionEvent actionEvent) {
    }
}
