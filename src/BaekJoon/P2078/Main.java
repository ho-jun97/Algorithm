package BaekJoon.P2078;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  https://www.acmicpc.net/problem/2078
 *  무한이진트리
 */

public class Main {
    static int A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        while(A!=0 && B!=0){
           if(A>B){
               left += A/B;
               A = A%B;
           }else{
               right += B/A;
               B = B%A;
           }
        }
        if(A==1){
            right--;
        }else{
            left--;
        }
        System.out.println(left + " " + right);
    }
}
