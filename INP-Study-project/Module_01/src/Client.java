import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        final int PORT=8003;

        Socket Socket = new Socket("localhost",PORT);

        PrintWriter printWriter = new PrintWriter(Socket.getOutputStream());
        printWriter.println("hellow Chat Application");
        printWriter.flush();
    }
}
