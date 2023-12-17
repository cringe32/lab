package lab4.TCP;
import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("server connecting....");
            Socket clientSocket = new Socket("127.0.0.1",2525);
            System.out.println("connection established....");
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            ObjectOutputStream coos = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream  cois = new ObjectInputStream(clientSocket.getInputStream());
            System.out.println("Enter any example to send to server \n\t('exit' − programme terminate)");
            String clientMessage = stdin.readLine();
            System.out.println("you've entered: "+clientMessage);
            while(!clientMessage.equals("exit")) {
                coos.writeObject(clientMessage);
                System.out.println("~server~: "+cois.readObject());
                System.out.println("---------------------------");
                clientMessage = stdin.readLine();
                System.out.println("you've entered: "+clientMessage);
            }
            coos.close();
            cois.close();
            clientSocket.close();
        }catch(Exception e)	{
            e.printStackTrace();
        }
    }
}
