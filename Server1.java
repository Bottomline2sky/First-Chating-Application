import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
            ServerSocket serverSocket;
            Socket  socket;
        System.out.println("Server Started");

        try {
            serverSocket = new ServerSocket(10002);
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        while (true){
            try{
            socket=serverSocket.accept();
            Thread t = new Thread(new ClientHandle1(socket));
            Thread t1 =new Thread (new ToClient(socket));
            t.start();
          t1.start();
        }
          catch(IOException e){
            e.printStackTrace();
            return;
        }
    }
    }
    }

