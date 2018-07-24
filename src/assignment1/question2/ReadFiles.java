package assignment1.question2;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFiles {
    public static void main(String[] args){
        if(args.length>0){
            for(int i=0;i<args.length;i++){
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(args[i])) ;
                    int lines=0 ;
                    while(reader.readLine() != null) lines++ ;
                    System.out.println("File name: " + args[i] + ", Lines:"+ lines); ;
                    reader.close() ;
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
}
