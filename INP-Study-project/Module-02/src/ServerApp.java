import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) throws IOException {
        final int PORT=8006;

        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket localSocket = serverSocket.accept();
        System.out.println("Port : "+localSocket.getPort());
        System.out.println("IP : "+localSocket.getInetAddress());
    }
}

