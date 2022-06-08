package BaekJoon.P2217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2217
 * [2217번:로프]-Silver4
 */

public class Main {
    static int N;
    static int[] rope;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        rope = new int[N];
        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope); // 오름차순 정렬
        int max=0;
        // 큰거부터 반복문 시작
        for(int i=rope.length-1; i>=0; i--){
            // 현재 로프 x 현재로프보다 큰 로프 개수
            int value = rope[i] * (rope.length-i);
            max = Math.max(max,value); // max 선택
        }
        System.out.println(max);
    }
}
