/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

/**
 *
 * @author erinearly
 */
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPserver{  
public static void main(String args[])throws Exception{   
    

System.out.println("Enter File Name: ");
String filename;
//System.out.println("Avalaible Files :");
Scanner input=new Scanner(System.in); //user input 
filename = input.nextLine(); //input stored as file name 
//userInput.close();

	
ServerSocket serverSoc=new ServerSocket(4445); 
System.out.println ("Waiting to connect"); //waits for client to connect
Socket socket=serverSoc.accept(); //accepts the connection request

//once connection is made 

System.out.println ("Connected With "+ socket.getInetAddress().getHostAddress());  //toString());

DataInputStream dataIn=new DataInputStream(socket.getInputStream());  //get input from client
DataOutputStream dataOut=new DataOutputStream(socket.getOutputStream());  //get output from client
//BufferedWriter bw = new BufferedWriter(dataOut.file1);
try 
{
      while (true) 
      {
        String data="";  

data = dataIn.readUTF(); //reading data in file (Content)
System.out.println("Scanning file data"); 

if(!data.equals("stop"))
{  

System.out.println("Sending File: " +filename);
dataOut.writeUTF(filename);  // sending file name to client 
dataOut.flush();  

File file=new File(filename); //Variable for file 
FileInputStream fileIn=new FileInputStream(file); // get file from folder
long size= (int) file.length(); 

byte b[]=new byte [1024]; //array for byte

int filedata; 

dataOut.writeUTF(Long.toString(size)); 
dataOut.flush(); 

System.out.println ("Size: " + size);


while((filedata = fileIn.read(b)) != -1) // checking file isnt null 
{
    dataOut.write(b, 0, filedata); 
    dataOut.flush(); 
}
//fileIn.close();
dataOut.flush(); 
}  
dataOut.writeUTF("stop");  //debugging 
System.out.println("File sent");
dataOut.flush();  
}
}
catch(Exception e)
{
	
}
dataIn.close();  
socket.close();  
serverSoc.close();  
}
}
//}


