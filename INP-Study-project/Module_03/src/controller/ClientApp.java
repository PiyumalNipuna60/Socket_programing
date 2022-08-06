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

    String massage="", reply="";

    public void initialize() {
        new Thread(()->{
            try {
                socket=new Socket("localhost",Port);
                txtAreaMsg.appendText("Accept Client..!");

                dataOutputStream=new DataOutputStream(socket.getOutputStream());
                dataInputStream=new java.io.DataInputStream(socket.getInputStream());

                InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


                while (massage.equals("Exit")){
                    massage=dataInputStream.readUTF();
                    txtAreaMsg.appendText(massage);

                    reply=bufferedReader.readLine();
                    dataOutputStream.writeUTF(reply);
                    dataOutputStream.flush();
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
