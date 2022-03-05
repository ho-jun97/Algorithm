package BaekJoon.P2864;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2864
 * [2864번: 5와 6의 차이]-Bronze2
 */

public class Main {
    static String A;
    static String B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = (st.nextToken());
        B = (st.nextToken());

        String minA="";
        String maxA="";
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i)=='5'){
                maxA += "6";
            }else{
                maxA += A.charAt(i);
            }
            if(A.charAt(i)=='6'){
                minA += '5';
            }else{
                minA += A.charAt(i);
            }
        }
        String minB="";
        String maxB="";
        for(int i=0; i<B.length(); i++){
            if(B.charAt(i)=='5'){
                maxB += "6";
            }else{
                maxB += B.charAt(i);
            }
            if(B.charAt(i)=='6'){
                minB += '5';
            }else{
                minB += B.charAt(i);
            }
        }

        int min = Integer.parseInt(minA) + Integer.parseInt(minB);
        int max = Integer.parseInt(maxA) + Integer.parseInt(maxB);
        System.out.println(min + " " + max);
    }
}
