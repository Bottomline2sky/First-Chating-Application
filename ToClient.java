import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.IOException;
 import java.io.BufferedReader;

public class ToClient implements Runnable{
     private Socket socket;
       ObjectOutputStream objectOutputStream;
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        ToClient(Socket socket){
              this.socket=socket;
            try{
                objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
            }
            catch(IOException e){
                   e.printStackTrace();
            }
            }
             public void run(){
            while(true){
                   try {
                       System.out.println("Enter 2 for quit the connection with client");
                       int ch = Integer.parseInt(bufferedReader.readLine());
                       if (ch == 2) {
                           break;
                       }
                       System.out.println("Enter Message");
                       String text = bufferedReader.readLine();
                       String from = "Server-" + Integer.toString(socket.getLocalPort());
                       MessageShared message = new MessageShared(text, from, "Client");
                       this.objectOutputStream.writeObject(message);
                       this.objectOutputStream.flush();
                   }
                   catch(IOException e){
                          e.printStackTrace();
                   }
            }
             }

}
