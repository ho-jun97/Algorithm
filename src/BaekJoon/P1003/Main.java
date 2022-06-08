package BaekJoon.P1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1003
 * [1003번: 피보나치 함수]-Silver3
 */

public class Main {
    static int T;
    static int[] zero;
    static int[] one;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        zero = new int[41];
        one = new int[41];
        zero[0] = 1; //0일 때 0의 개수
        one[0] = 0; // 0일 때 1의 개수
        zero[1] = 0; // 1일 때 0의 개수
        one[1] = 1; // 1일 때 1의 개수
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=2; j<=n; j++){
                zero[j] = zero[j-1]+ zero[j-2];
                one[j] = one[j-1]+ one[j-2];
            }
            sb.append(zero[n]).append(" ").append(one[n]).append('\n');
        }
        System.out.println(sb.toString());
    }
}
