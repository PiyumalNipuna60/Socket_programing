import java.io.*;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        final int PORT = 8006;

        try {
            Socket localhost = new Socket("localhost", PORT);

            System.out.println("Server Accept..!");

            DataOutputStream dataOutputStream = new DataOutputStream(localhost.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(localhost.getInputStream());

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String massage = "", reply = "";
            while (massage.equals("Exit")) {
                //input Massage
                massage = dataInputStream.readUTF();
                System.out.println(massage);

                //reply massage
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
