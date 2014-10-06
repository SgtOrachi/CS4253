import java.io.*;
import java.net.*;
import java.io.FileInputStream;
import java.io.ByteArrayInputStream;


public class UDPServer
{
    public static void main(String args[])
    {
        DatagramSocket sock = null;
         
        try
        {
            sock = new DatagramSocket(7777);
             
            byte[] buffer = new byte[65536];
            DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
             
            echo("Server socket created. Waiting for incoming data...");
             
            while(true)
            {
                sock.receive(incoming);
                byte[] data = incoming.getData();
                String s = new String(data, 0, incoming.getLength());
                File audio = new File("C:/Users/Jason/Documents/The name of the wind/00.mp3");
                FileInputStream audiostream = null;
                DatagramPacket pack;
                
                echo(incoming.getAddress().getHostAddress() + " : " + incoming.getPort() + " - " + s);
                 
                if (s.equals("grab audio 1")){
                	echo("loading audio file");
                	//DatagramPacket pack = new DatagramPacket(buf, );
                    //sock.send(pack);
                }
                else if (s.equals("grab video 1")){	
                	echo("loading video file");
                	//DatagramPacket pack = new DatagramPacket();
                	//sock.send(pack);
                }
                s = "OK : " + s;
                DatagramPacket msg = new DatagramPacket(s.getBytes() , s.getBytes().length , incoming.getAddress() , incoming.getPort());
                sock.send(msg);
            }
        }
         
        catch(IOException e)
        {
            System.err.println("IOException " + e);
        }
    }
    public static void echo(String msg)
    {
        System.out.println(msg);
    }
}