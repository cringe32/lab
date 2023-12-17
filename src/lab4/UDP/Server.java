package lab4.UDP;
import java.net.*;
import java.io.*;
import static java.lang.Math.*;

public class Server {
    public final static int DEFAULT_PORT = 8001;
    public final String VERSION_CMD = "VERS";
    public final String QUIT_CMD = "QUIT";
    public final String SOLUTION_CMD = "SOLUTION";
    public final byte[] VERSION = { 'V', '2', '.', '0' };
    public final byte[] UNKNOWN_CMD = { 'U', 'n', 'k', 'n', 'o', 'w', 'n', ' ', 'c', 'o', 'm', 'm', 'a', 'n', 'd' };

    public void runServer() throws IOException {//метод сервера runServer
        DatagramSocket s = null;//создание объекта DatagramSocket
        try {
            boolean stopFlag = false;//создание флага stopFlag и его инициализация
//значением false
            byte[] buf = new byte[512];//буфер для приема/передачи дейтаграммы
            s = new DatagramSocket(DEFAULT_PORT);//привязка сокета к
//реальному объекту с портом DEFAULT_PORT
            System.out.println("UDPServer: Started on " + s.getLocalAddress() + ":"
                    + s.getLocalPort());//вывод к консоль сообщения
            while(!stopFlag) {//цикл до тех пор, пока флаг не примет значение true
                DatagramPacket recvPacket = new DatagramPacket(buf, buf.length);//создание объекта дейтаграммы для получения данных
                s.receive(recvPacket);//помещение полученного содержимого в
//объект дейтаграммы
                String cmd = new String(recvPacket.getData()).trim();//извлечение
//команды из пакета
                DatagramPacket sendPacket = new DatagramPacket(buf, 0, recvPacket.getAddress(), recvPacket.getPort());                                                                  // дейтаграммы для отсылки данных
                int n = 0;
                if (cmd.length() >= 8) {
                    if (cmd.substring(0, 8).equals(SOLUTION_CMD)) {
                        System.out.println("UDPServer: Command: " + SOLUTION_CMD);
                        String[] data = cmd.split(" ");
                        double x = Double.parseDouble(data[1]);
                        double y = Double.parseDouble(data[2]);
                        double res = log(pow(y, -pow(abs(x), 0.5))) * (x - y / 2) + pow(sin(atan(x + pow(E, (x + y)))), 2);
                        String result = String.format("%.3f", res);
                        n = result.length();
                        byte[] resByte = result.getBytes();
                        System.arraycopy(resByte, 0, buf, 0, n);
                    }
                    else {
                        n = UNKNOWN_CMD.length;
                        System.arraycopy(UNKNOWN_CMD, 0, buf, 0, n);
                    }
                }
                else {
                    System.out.println("UDPServer: Command: " + cmd);
                    if (cmd.equals(VERSION_CMD)) {//проверка версии команды
                        n = VERSION.length;
                        System.arraycopy(VERSION, 0, buf, 0, n);
                    }
                    else if (cmd.equals(QUIT_CMD)) {
                        stopFlag = true;//остановка сервера
                        continue;
                    }
                    else {
                        n = UNKNOWN_CMD.length;
                        System.arraycopy(UNKNOWN_CMD, 0, buf, 0, n);
                    }

                }
                sendPacket.setData(buf);//установить массив посылаемых данных
                sendPacket.setLength(n);//установить длину посылаемых данных
                s.send(sendPacket);//послать сами данные
            } // while(server is not stopped)
            System.out.println("UDPServer: Stopped");
        }
        finally {
            if (s != null) {
                s.close();//закрытие сокета сервера
            }
        }
    }
    public static void main(String[] args) {//метод main
        try {
            Server udpSvr = new Server();//создание объекта udpSvr
            udpSvr.runServer();//вызов метода объекта runServer
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}

