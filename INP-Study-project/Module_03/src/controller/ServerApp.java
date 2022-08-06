package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
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

    String massage="", reply="";

    public void initialize() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(PORT);
                txtAreaMsg.appendText("Server Start.!");
                localSocket = serverSocket.accept();
                txtAreaMsg.appendText("Client Connected..!");

                dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
                dataInputStream = new java.io.DataInputStream(localSocket.getInputStream());
                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


                while (massage.equals("Exit")){
                    massage=dataInputStream.readUTF();
                    txtAreaMsg.appendText(massage);

//                    reply=bufferedReader.readLine();
//                    dataOutputStream.writeUTF(reply);
//                    dataOutputStream.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    public void btnSentOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtMsg.getText());
        dataOutputStream.flush();
    }
}
