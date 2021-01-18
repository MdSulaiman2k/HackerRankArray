import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int total = 0 ;
        int cnt = 0 ;
        int maxtotal = 0 ; 
        for(int l = 0 ; l < 4 ; l++){
        for(int k = 0 ; k < 4 ; k++ ){
            for( int i = l ; i <= l+2 ; i++ ){
                for(int j = k ; j <= k+2 ; j++ ){
                    if( i == l+1 && (j == k || j ==k+2 ) )
                      ;
                    else  {
                       total += arr[i][j] ;}
                } 
            }
            if(l == 0 && k==0) maxtotal = total ;
          
            if(total > maxtotal){
                maxtotal = total ;
            }
            total = 0 ;
        }
        }
        return maxtotal ;
       
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
