package BaekJoon.P2437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2437
 * [2437번: 저울]-Gold3
 */

public class Main {
    static int N;
    static int[] weight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weight = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight); // 오름차순 정렬
        int sum=0;
        for(int i=0; i<N; i++){
            if(sum+1 < weight[i]){ // 현재의 추가 그전까지의 추의 합 + 1보다 클 때
                break;
            }
            sum += weight[i];
        }
        System.out.println(sum+1);
    }
}
