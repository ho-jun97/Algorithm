package BaekJoon.P1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1789
 * [1789번: 수들의 합]-Sliver5
 */

public class Main {
    static long S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Long.parseLong(br.readLine());

        long sum = 0;
        int N = 0;
        int num=1;
        while(true){
            if(sum > S){
                break;
            }
            sum += num++;
            N++;
        }
        System.out.println(N-1);
    }
}
