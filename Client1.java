import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 10002);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client Created.");
            System.out.println("Enter name of client.");
            String name = bufferedReader.readLine();
            new Client1().sendMessage(socket, bufferedReader, name);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMessage(Socket socket, BufferedReader bufferedReader, String name) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        Thread t = new Thread(new ServerHandle1(socket));
        t.start();
        while (true) {
            System.out.println("Press  1 to finish your connection");
            int ch = Integer.parseInt(bufferedReader.readLine());
            if (ch == 1) {
                break;
            }
            System.out.println("Enter Message");
            String text = bufferedReader.readLine();
            String from = "Client-" + name;
            MessageShared message = new MessageShared(text, from, "Server");
            objectOutputStream.writeObject(message);
            objectOutputStream.flush();
        }
    }
}






