package BaekJoon.P2720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2720
 * [2720번: 세탁소 사장 동혁]-Bronze3
 */

public class Main {
    static int Quarter = 25;
    static int Dime = 10;
    static int Nickel = 5;
    static int Penny = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            int q=0,d=0,n=0,p=0;
            while(num!=0){
                if(num >= Quarter){
                    q = num/Quarter;
                    num = num%Quarter;
                }else if(num>=Dime){
                    d = num/Dime;
                    num = num%Dime;
                }else if(num>=Nickel){
                    n = num/Nickel;
                    num = num%Nickel;
                }else if(num>=Penny){
                    p = num/Penny;
                    num = num%Penny;
                }
            }
            System.out.println(q + " " + d + " " + n + " " + p);
        }
    }
}
