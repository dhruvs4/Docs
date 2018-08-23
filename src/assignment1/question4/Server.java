package assignment1.question4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println(args.length);
            File f = new File(args[0]);
            File[] files = f.listFiles();

            ServerSocket ss = new ServerSocket(8080);
            Socket s = ss.accept();
            DataInputStream dataInputStream = new DataInputStream(s.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(s.getOutputStream());

            String query = dataInputStream.readUTF();
            String response = new String();

            if (query.equals("index"))
                for (File file1 : files)
                    response += (file1.getName() + " ");
            else if (query.substring(0, 3).equals("get")) {
                String filename = query.substring(4, query.length());
                for (File file1 : files) {
                    if (file1.getName().equals(filename)) {
                        FileReader fr = new FileReader(file1);
                        BufferedReader br = new BufferedReader(fr);
                        String readline = new String();
                        while (( readline= br.readLine()) != null) {
                            response += readline;
                        }
                    }
                }
                if (response.equals("")) response += "File not found";
            }
            System.out.println(response);

            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();

            dataInputStream.close();
            dataOutputStream.close();

            ss.close();
            s.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}