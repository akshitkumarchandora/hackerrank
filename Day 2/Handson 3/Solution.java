import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int lcm(int a,int b)
    {
        int lcm=b;
        if(a==b)
        return lcm;
        while(lcm%a!=0)
        {
            lcm+=b;
        }
        return lcm;
    }

    public static int gcd(int a,int b)
    {
        
        if(a==0)
        return b;
        
        return gcd(b%a,a);
    }
    public static int getTotalX(List<Integer> a, List<Integer> b) {
    // Write your code here
    Collections.sort(a);
    Collections.sort(b);
    int lcmOfA=a.get(0);
    int gcdOfB=b.get(0);
    int count=0;int icount=0;
    if(b.size()!=1)
    {
        for(int i=0;i<b.size()-1;i++)
        gcdOfB=gcd(gcdOfB,b.get(i+1));
    }
    if(gcdOfB==1 )
    return 0;

    if(a.size()!=1)
    {
        for(int i=0;i<a.size()-1;i++)
            lcmOfA=lcm(lcmOfA,a.get(i+1));

        }
    
    
    for(int i=lcmOfA;i<=gcdOfB;i+=lcmOfA)
    {
        icount=0;
        for(int j=0;j<b.size();j++)
        {
            if(b.get(j)%i==0)
            icount++;
            else break;
        }
        if(icount==b.size())
            count++;
    
    }
    
    return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
