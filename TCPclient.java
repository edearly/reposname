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

class TCPclient{  
public static void main(String args[])throws Exception{  
String address = "";  //definging a empty string to add the IP address
Scanner scanner=new Scanner(System.in);  //accepts input from user 
System.out.println("Enter Server Address: ");  //debugging, control which address to use
address=scanner.nextLine(); //passing user input into empty string
Socket socket=new Socket(address,4445);  //same port number as UDP 
DataInputStream dataIn=new DataInputStream(socket.getInputStream());  //get input from user
DataOutputStream dataOut=new DataOutputStream(socket.getOutputStream());  // show Output from user
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  //

System.out.println("tell server to start...");
String str="",filename="";  // be able to choose a file on your pc
try{  //
while(!str.equals("start"))
	str=br.readLine(); 
 
	dataOut.writeUTF(str); 
	dataOut.flush();  
	
	filename=dataIn.readUTF(); 
	System.out.println("Receving file: "+filename); //debugging 
	filename="client"+filename;
	System.out.println("Saving as file: "+filename); //debugging 
//
long sz=Long.parseLong(dataIn.readUTF());
System.out.println ("File Size: "+(sz/(1024*1024))+" MB");

byte b[]=new byte [1024];
System.out.println("Receving file..");
FileOutputStream fos=new FileOutputStream(new File(filename),true);
long bytesRead;
do
{
bytesRead = dataIn.read(b, 0, b.length);
fos.write(b,0,b.length);
}while(!(bytesRead<1024));
System.out.println("Comleted");
fos.close(); 
dataOut.close();  	
socket.close();  
}
catch(EOFException e)
{
	
}
}
}
    
