package lab4.TCP;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientAccepted = null;
        ObjectInputStream sois = null;
        ObjectOutputStream soos = null;
        try {
            System.out.println("server starting....");
            serverSocket = new ServerSocket(2525);
            clientAccepted = serverSocket.accept();
            System.out.println("connection established....");
            sois = new ObjectInputStream(clientAccepted.getInputStream());
            soos = new ObjectOutputStream(clientAccepted.getOutputStream());
            String clientMessageRecieved = (String)sois.readObject();
            while(!clientMessageRecieved.equals("exit")) {
                System.out.println("example recieved: '"+clientMessageRecieved+"'");
                clientMessageRecieved = сalculate(clientMessageRecieved);
                soos.writeObject(clientMessageRecieved);
                clientMessageRecieved = (String)sois.readObject();
            }
        } catch(Exception e)	{
        } finally {
            try {
                sois.close();
                soos.close();
                clientAccepted.close();
                serverSocket.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String сalculate(String example) {
        String result;
        String[] elements = example.split(" ");
        double res = 0;
        switch (elements[1]) {
            case ("+"):
               res = Double.parseDouble(elements[0]) + Double.parseDouble(elements[2]);
               break;
            case ("-"):
                res = Double.parseDouble(elements[0]) - Double.parseDouble(elements[2]);
                break;
            case ("*"):
                res = Double.parseDouble(elements[0]) * Double.parseDouble(elements[2]);
                break;
            case ("/"):
                res = Double.parseDouble(elements[0]) / Double.parseDouble(elements[2]);
                break;
        }
        result = String.format("%s = %.2f", example, res);
        return result;
    }
}


