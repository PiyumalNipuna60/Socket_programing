package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(PORT);
                System.out.println("Server Start.!");
                localSocket = serverSocket.accept();
                System.out.println("Client Connected..!");

                dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
                dataInputStream = new java.io.DataInputStream(localSocket.getInputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public void btnSentOnAction(ActionEvent actionEvent) {
    }
}
