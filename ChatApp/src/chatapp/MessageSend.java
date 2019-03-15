
package chatapp;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageSend extends Thread{
   String message,hostname;
   int port;
    public MessageSend(String message, String hostname, int port) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }

    @Override
    public void run() {
       try {
           Socket s=new Socket(hostname,port);
           s.getOutputStream().write(message.getBytes());//mesajı karşı tarafa aktar.
           s.close();
       } catch (IOException ex) {
           System.out.println("Bağlanılamadı..!");
       }
    }
   
   
}
