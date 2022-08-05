package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.omg.CORBA.DataInputStream;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    final int PORT = 8007;
    public Button btnSent;
    public TextArea txtAreaMsg;
    public TextField txtMsg;
    ServerSocket serverSocket;
    Socket localSocket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public void initialize() {

    }


    public void btnSentOnAction(ActionEvent actionEvent) {
    }
}
