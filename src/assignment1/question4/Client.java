package assignment1.question4;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",8080);
            DataOutputStream dataOutputStream=new DataOutputStream(s.getOutputStream());
            System.out.println("Enter query: ");
            Scanner scanner = new Scanner(System.in);
            String query = scanner.nextLine();
            dataOutputStream.writeUTF(query);
            dataOutputStream.flush();

            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
            String response = dataInputStream.readUTF();
            System.out.println(response);
            dataInputStream.close();
            dataOutputStream.close();
            s.close();
        }
        catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}