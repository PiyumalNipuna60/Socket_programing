package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class ClientApp {
    final int Port = 8007;
    public TextArea txtAreaMsg;
    public TextField txtMsg;
    public Button btnSent;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    BufferedReader bufferedReader;

    String massage="", reply="";

    public void initialize() {
        new Thread(()->{
            try {
                socket=new Socket("localhost",Port);
                txtAreaMsg.appendText("Accept Client..!");
                txtAreaMsg.appendText("\n.............................................\n");

                dataOutputStream=new DataOutputStream(socket.getOutputStream());
                dataInputStream=new java.io.DataInputStream(socket.getInputStream());

                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                bufferedReader = new BufferedReader(inputStreamReader);


                while (!massage.equals("Exit")){
                    massage=dataInputStream.readUTF();
                    txtAreaMsg.appendText("\nServer : "+massage);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void btnSentOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtMsg.getText());
        txtAreaMsg.appendText("\nClient : "+txtMsg.getText());
        dataOutputStream.flush();
    }
}
