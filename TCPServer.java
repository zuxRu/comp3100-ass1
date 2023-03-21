import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.concurrent.TimeUnit;

public class TCPServer {
    public static void main(String[] args) {
        int aPort = Integer.parseInt(args[0]);
        System.out.println("Port Number: " + aPort);
        ServerSocket ss = new ServerSocket(aPort);
        while (true) {
            try {
                Socket s = ss.accept();// does what you think establishes the connection.
                DataInputStream din = new DataInputStream(s.getInputStream());
                DataOutputStream dout = new DataOutputStream(s.getOutputStream());

                System.out.println("Target IP: " + s.getInetAddress() + " Target Port " + s.getPort());
                System.out.println("Local IP: " + s.getLocalAddress() + " Local Port " + s.getLocalPort());
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }

                String str = (String) din.readUTF();
                System.out.println("RCVD: " + str);

                dout.writeUTF("G'DAY");
                System.out.print("SENT: G'DAY");

                dout.writeUTF("BYE");
                System.out.println("SENT: BYE");

                din.close();
                dout.close();
                s.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}