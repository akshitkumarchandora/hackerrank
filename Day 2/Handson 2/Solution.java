import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        String st="";
        String day=s.substring(8,10);
        String time=s.substring(0,8);
        int hr=Integer.parseInt(s.substring(0,2));
        String min=s.substring(3,5);
        String ss=s.substring(6,8);
        if(day.equals("AM"))
        {
            if(hr == 12)
            st="00:"+min+":"+ss;
            else
            st=time;
        }
        if(day.equals("PM"))
        {
            if(hr!= 12)
            {
                hr=hr+12;
                st=hr+":"+min+":"+ss;
            }
            else
            st=time;
        }
        
    return st;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
