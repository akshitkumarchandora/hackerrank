import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    
    static String isBalanced(String s) {
         int l=s.length();
         Stack<String> ds=new Stack<String>();
        
         int flag=1;
            if(l%2==1)
            System.out.println("false");//1st
            else
            {   flag=1;
                for(int i=0;i<l;i++)
                {
                    String c=""+s.charAt(i);
                    if(ds.size()==0 && (c.equals("}")||c.equals(")")||c.equals("]")))
                    {
                        flag=0;
                        ds.clear();
                        break;
                    }
                    else if(c.equals("{")||c.equals("(")||c.equals("["))
                    {
                     ds.add(c);   
                    }//inner else if
                    else
                    { 
                    if(c.equals("}") && "{".equals(ds.peek()))
                    ds.pop();
                    else if(c.equals("]") && "[".equals(ds.peek()))
                    ds.pop();
                    else if(c.equals(")") && "(".equals(ds.peek()))
                    ds.pop();
                    else 
                    {flag=0;ds.clear();break;}
                    
                     }//else

                }//loop

            if(flag==1 && ds.size()==0)
            return "YES";
            
           // ds.clear();
            }//else outer
            
            return "NO";


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
