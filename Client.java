/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author erinearly
 */
public class Client {
    public static void main(String args []) throws UnknownHostException, IOException
    {
    try
    {
    int number, temp;
    Socket socket = new Socket ("127.0.0.1", 4445); //
    System.out.println("connected");
    } catch (Exception e) {}
    /*
    Scanner scanner = new Scanner(System.in); //accept input from user
    Scanner scanner1 = new Scanner (socket.getInputStream()); //get the input from server
    
    //while ();
    System.out.println(socket);
    System.out.println("enter number");
    number = scanner.nextInt(); //store output 
    PrintStream ps= new PrintStream(socket.getOutputStream()); //
    ps.println(number); //print 
    temp = scanner1.nextInt(); //accepting result from user 
    System.out.println(temp);
    
    
    
    
}
    */
}
}
