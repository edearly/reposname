/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

/**
 *
 * @author erinearly
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class TCPclient{  
    
public static void main(String args[])throws Exception{  
    
    
String address = "";  //defining a empty string to add the IP address
Scanner scanner=new Scanner(System.in);  //accepts input from user 
System.out.println("Enter Server Address: ");  //debugging, control which address to use
address=scanner.nextLine(); //passing user input into empty string
Socket socket=new Socket(address,4445);  //same port number as UDP 
DataInputStream dataIn=new DataInputStream(socket.getInputStream());  //get input from user
DataOutputStream dataOut=new DataOutputStream(socket.getOutputStream());  // show Output from user
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  //

System.out.println("start server...");
String s="",filename = "";  // be able to choose a file on your pc
try{  //
while(s.equals("start")) //starting the server
	s = br.readLine(); //reading user input
 
	dataOut.writeUTF(s); //write information to the output stream
	dataOut.flush();  
	
	filename = dataIn.readUTF(); //reading data from file and put into empty string 
	System.out.println("Receving file: "+filename); //debugging 
	filename="New"+filename; //new name for file
	System.out.println("Saving as file: "+filename); //debugging 
//
long size =Long.parseLong(dataIn.readUTF()); //declaring variable for file size
     // string to int
System.out.println ("File Size: "+ size +" MB"); //printing File size
  //indicate file content is saving or saved 

byte b[]=new byte [1024]; //standard size?
System.out.println("Saving file.."); //debugging 
FileOutputStream fileOut = new FileOutputStream(new File(filename),true);
long receivedBytes;
do
{
    receivedBytes = dataIn.read(b, 0, b.length); //bytes in file
    fileOut.write(b,0, b.length); //writing/saving all bytes to file 
    
}
while (!(receivedBytes < 1024)); //all bytes received in file
   System.out.println("File Saved"); //debugging
}
catch(EOFException e)
{
    
}
}
} 
    
