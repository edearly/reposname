/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author erinearly
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException 
     {
         try
         {
    ServerSocket servSoc = new ServerSocket(4445);
    Socket soc = servSoc.accept(); //accept request to this socket
    System.out.println("Connected");
         } catch (Exception e){}
         /*
    Scanner scan = new Scanner(soc.getInputStream()); //scanner to use the sicket
         int number = scan.nextInt(); //accept number from the user
         System.out.println("Number Recieved");
         int temp = number * 2;
         System.out.println("number returned " + temp);
         PrintStream ps = new PrintStream(soc.getOutputStream());
         ps.println(temp);
         //System.out.print("Message to server recieved");
         //}
    //}
     }
    /*
    public static void main(String[] args) throws IOException 
     {
    ServerSocket servSoc = new ServerSocket(4445);
    Socket soc = servSoc.accept();
    Scanner scan = new Scanner(soc.getInputStream());
         String message = scan.next();
         while(true)
         {
         String temp = message;
         PrintStream ps = new PrintStream(soc.getOutputStream());
         ps.println(temp);
         System.out.print("Message to server recieved");
         }
    
     }
*/
}
}
    
    

