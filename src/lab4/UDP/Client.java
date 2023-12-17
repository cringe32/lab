package lab4.UDP;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {//описание класса клиента
    public void runClient() throws IOException {//метод клиента runClient
        DatagramSocket s = null;//создание дейтаграммы
        try {
            byte[] buf = new byte[512]; //буфер для приема/передачи дейтаграммы
            s = new DatagramSocket();//привязка сокета к реальному объету
            System.out.println("UDPClient: Started");
            byte[] verCmd = { 'V', 'E', 'R', 'S' };
            DatagramPacket sendPacket = new DatagramPacket(verCmd, verCmd.length, InetAddress.getByName("127.0.0.1"), 8001);//создание
//дейтаграммы для отсылки данных
            s.send(sendPacket);//посылка дейтаграммы
            DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание дейтаграммы для получения данных
            s.receive(recvPacket);//получение дейтаграммы
            String version = new String(recvPacket.getData()).trim();//извлечение
//данных (версии сервера)
            System.out.println("UDPClient: Server Version: " + version);

            System.out.println("UDPClient: a = ln(y^(-√|x|) * (x - y/2) + sin^2(arctg(x + e^(x + y)))");
            Scanner in = new Scanner(System.in);
            System.out.println("UDPClient: Enter x");
            String x = String.valueOf(in.nextDouble());
            System.out.println("UDPClient: Enter y");
            String y = String.valueOf(in.nextDouble());
            String separator = " ";
            byte[] sep = separator.getBytes();
            byte[] xBytes = x.getBytes();
            byte[] yBytes = y.getBytes();
            byte[] sol = { 'S', 'O', 'L', 'U', 'T', 'I', 'O', 'N'};
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(sol);
            outputStream.write(sep);
            outputStream.write(xBytes);
            outputStream.write(sep);
            outputStream.write(yBytes);
            byte[] solCmd = outputStream.toByteArray();
            sendPacket.setData(solCmd);
            sendPacket.setLength(solCmd.length);
            s.send(sendPacket);
            s.receive(recvPacket);
            String result = new String(recvPacket.getData());
            System.out.println("UDPClient: a = " + result);

            byte[] quitCmd = { 'Q', 'U', 'I', 'T' };
            sendPacket.setData(quitCmd);//установить массив посылаемых данных
            sendPacket.setLength(quitCmd.length);//установить длину посылаемых данных
            s.send(sendPacket); //послать данные серверу
            System.out.println("UDPClient: Ended");
        }
        finally {
            if (s != null) {
                s.close();//закрытие сокета клиента
            }  }  }
    public static void main(String[] args) {//метод main
        try {
            Client client = new Client();//создание объекта client
            client.runClient();//вызов метода объекта client
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
