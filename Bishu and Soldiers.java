import java.io.*;

import java.math.*;
import java.util.*;



public class TestCase {

    static MyScanner in = new MyScanner();
    static   PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
    int N;
    static int [][] BIT;
    static int max = 200000;
    static long [] arr;
    static long []prefix;
    public static void main(String args[]) throws IOException {
        int n = in.nextInt();
        arr = new long [n];
        prefix = new long[n];
        for(int i=0;i<arr.length;i++)
        arr[i] = in.nextInt();
        Arrays.sort(arr);
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = arr[i] +prefix[i-1];
        }
        //upperbound
        int Q = in.nextInt();
        while(Q-->0){
        int low =0;
        int hi = n-1;
        int M = in.nextInt();
            while(low<hi){
                int mid = low+(hi-low)/2;
                if(arr[mid]>M){
                    hi = mid;
                }else{
                    low = mid+1;
                }
            }
            if(M>=n){
                pw.println(n+" "+prefix[n-1]);
            }else{
                if(arr[low]==M){
                    pw.println(low+1+" "+prefix[low]);
                }else{
                    pw.println(low+" "+prefix[low-1]);
                }
            }
        }
        
pw.flush();

        }

    
