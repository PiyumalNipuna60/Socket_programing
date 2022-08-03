import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        final int PORT=8003;
        ServerSocket serverSocket=new ServerSocket(PORT);
        Socket localSocket = serverSocket.accept();
        System.out.println("Port : "+localSocket.getPort());
        System.out.println("IP : "+localSocket.getInetAddress());

        InputStreamReader inputStreamReader = new InputStreamReader(localSocket.getInputStream());


    }
}
