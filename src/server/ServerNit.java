package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import modeli.*;

public class ServerNit extends Thread{

    Socket sockt;

    public ServerNit(Socket sockt) {
        this.sockt = sockt;
    }
    
    @Override
    public void run() {
        try {
            ObjectOutputStream os=new ObjectOutputStream(sockt.getOutputStream());
            ObjectInputStream is=new ObjectInputStream(sockt.getInputStream());
            //obrada request-a
            Object request=is.readUnshared();
            String odgovor="";
            SimpleDateFormat spdt=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dt=new Date();
            switch(request.getClass().getSimpleName())
            {
                case "Palindrom":
                    odgovor=new PalindromControler((Palindrom)request).ispitaj();
                    os.writeUnshared(odgovor);
                    System.out.println(spdt.format(dt)+" Klijent zahteva zadatak 1.");
                    break;
                case "Sistem":
                    odgovor=new SistemControler((Sistem)request).izracunaj();
                    os.writeUnshared(odgovor);
                    System.out.println(spdt.format(dt)+" Klijent zahteva zadatak 2.");
                    break;
                case "Lavirint":
                    odgovor=new LavirintControler((Lavirint)request).trazi();
                    os.writeUnshared(odgovor);
                    System.out.println(spdt.format(dt)+" Klijent zahteva zadatak 3.");
                    break;
            }
            os.close();
            is.close();
            sockt.close();
        } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }
}