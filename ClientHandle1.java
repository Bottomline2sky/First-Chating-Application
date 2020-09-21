import java.io.IOException;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class ClientHandle1 implements Runnable {
    private Socket socket;
    ObjectInputStream objectInputStream;

    public ClientHandle1(Socket socket) {
        this.socket = socket;
        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {
                MessageShared message = (MessageShared)objectInputStream.readObject();
                System.out.println("Message Received");
                System.out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}

