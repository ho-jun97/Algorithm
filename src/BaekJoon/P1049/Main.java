package BaekJoon.P1049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1049
 * [1049번: 기타줄]-Sliver4
 */

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] pack = new int[M];
        int[] one = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());
            pack[i] = p;
            one[i] = o;
        }
        Arrays.sort(pack);
        Arrays.sort(one);

        int n = N/6;
        int remain = N%6;

        // 6개팩 가격으로 다사기 vs 1개 가격으로 사기 vs 6개팩+1개 가격으로 사기
        int min = Math.min((n+1)*pack[0],Math.min(N*one[0], n*pack[0]+remain*one[0]));
        System.out.println(min);

    }
}
