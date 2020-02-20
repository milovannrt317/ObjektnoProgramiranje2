package server;

import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(5700);
            System.out.println("Server je pokrenut.");
            while (true) {
                Socket sockt=ss.accept();
                new ServerNit(sockt).start();
                System.out.println("Klijent prihvacen!");
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
           
        }
      
    }
}

