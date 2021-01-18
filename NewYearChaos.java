import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class arrorder {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int ck = 1 ;
        int [] checking =  new int[q.length] ;
        Arrays.fill(checking , 0 ) ;
        int cnt = 0 ;
        for(int i = 0 ; i < q.length  ; i++){
            if(ck != q[i]){
                 checking[i]++;
                 cnt++;
                 if(checking[i] > 2 )
                    break;
                 for(int j = ck ; j < q.length ; j++){
                     if(ck == q[j]){
                         checking[j]++ ;
                         int val = q[i] ;
                         q[i]    =  q[j] ;
                         q[j]   = val ;
                         break ;
                     }
                     
                 }
            }
            ck++;
        }
        boolean chk =  true ;
        for(int i = 0 ; i < q.length ; i++){
            if(checking[i] > 2){
                chk = false ; 
            }
        }
        System.out.println(chk ? cnt : "Too chaotic") ;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
