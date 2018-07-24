package assignment1.question1;

import java.io.File;

public class GetFiles {
    static void rec(File[] arr,int start,int level){
        for(File f:arr) {
            for (int i = 0; i < level; i++)
                System.out.print('\t');
            if (f.isFile())
                System.out.println(f.getName());
            else if (f.isDirectory()) {
                System.out.println("[" + f.getName() + "]");
                rec(f.listFiles(), 0, level + 1);
            }
        }
    }

    public static void main(String[] args){
        String maindirpath = "/home/dhruvsharma/Documents/test1" ;
        File maindir = new File(maindirpath) ;
        if(maindir.exists() && maindir.isDirectory()){
            File arr[]  = maindir.listFiles();
            System.out.println("Files from main dir:" + maindir) ;
            rec(arr,0,0);
        }
    }
}