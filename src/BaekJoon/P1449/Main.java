package BaekJoon.P1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1449
 * [1449번: 수리공 항승]-Silver3
 */

public class Main {
    static int N,L;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int count=1;
        int standard = arr[0];
        for(int i=1; i<N; i++){
            // 1. 해당 위치에서 테이프를 붙혔을 때 다음 물이 새는 곳보다 작을 때
            if(standard+L-1 < arr[i]){ //  -1하는 이유 -> 해당 위치까지 테이플 길이를 포함해야 함
                standard = arr[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
