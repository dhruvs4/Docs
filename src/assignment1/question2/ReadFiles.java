package assignment1.question2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;

public class ReadFiles {
    public static void main(String[] args){
        if(args.length>0){
            for(int i=0;i<args.length;i++){
                try {
                    int lines = count_lines(args[i]) ;
                    if(lines!=1) {
                        System.out.println("File name: " + args[i] + ", Lines:"+ lines); ;
                    }
                    else System.out.println("error in file");
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    static int count_lines(String f){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f)) ;
            int lines=0 ;
            while(reader.readLine() != null) lines++ ;
            reader.close() ;
            return lines ;
        }
        catch(Exception e){
            return -1 ;
        }
    }
}

