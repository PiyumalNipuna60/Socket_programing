import java.io.IOException;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        final int PORT=8006;
        Socket localhost = new Socket("localhost", PORT);
    }
}
