import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        final int PORT = 8006;

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket localSocket = serverSocket.accept();
        System.out.println("Client Accept..!");

        DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String massage = "", reply = "";
        while (!massage.equals("Exit")) {
            //input Massage
            massage = dataInputStream.readUTF();
            System.out.println(massage);

            //reply massage
            reply = bufferedReader.readLine();
            dataOutputStream.writeUTF(reply);
            dataOutputStream.flush();

        }

    }
}

