package BaekJoon.P1052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1052
 * [1052번: 물병]-Sliver1
 */

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int n = N;
        int answer = 0;

        while (true) {
            int count = 0; // 물병의 개수
            int temp = n; //  현재 물병의 총 개수
            while (temp != 0) {
                if (temp % 2 == 1) {
                    count++; // 들고 가야하는 물병 개수 추가
                }
                temp = temp / 2;
            }
            if (count <= K) break; // 물병의 개수가 K보다 작거나 같으면 모두 들고 갈 수 있으니깐 종료
            answer++;
            n++; // 현재로써 물병의 개수로 안되므로 물병 1개 추가
        }
        System.out.println(answer);
    }
}

