package assignment1.question5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractData {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://en.wikipedia.org/wiki/Albert_Einstein");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        String inputLine;
        System.out.println(in.readLine());
        String extracted = "" ;
        while ((inputLine = in.readLine()) != null)
            extracted+=inputLine ;
        System.out.println(extracted);
        in.close();
        Pattern p = Pattern.compile("[A-Za-z]*=");
        Matcher m = p.matcher(extracted) ;
        while (m.find())
            System.out.println(extracted.substring(m.start(),(m.end()-1)));
    }
}
