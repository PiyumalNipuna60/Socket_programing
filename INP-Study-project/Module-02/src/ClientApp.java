import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args){
        final int PORT=8006;

        try {
            Socket localhost = new Socket("localhost", PORT);

            System.out.println("Server Accept..!");

            DataOutputStream dataOutputStream = new DataOutputStream(localhost.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(localhost.getInputStream());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
