package BaekJoon.P2828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2828
 * [2828번: 사과 담기 게임]-Sliver5
 */

public class Main {
    static int N,M,J;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        J = Integer.parseInt(br.readLine());

        int left = 1;
        int right = left+(M-1);
        int answer = 0;
        for(int i=0; i<J; i++){
            int num = Integer.parseInt(br.readLine());
            // 2. 바구니 크기 밖에 있을 때
            // 2-1. 바구니 위치가 사과 떨어지는 위치보다 왼쪽일 때
            if(right<num){
                // 2-1-1 바구니 위치를 오른쪽으로 이동
                answer += (num-right);
                right = num;
                left = right-(M-1);
            }
            // 2-2  바구니 위치가 사과 떨어지는 위치보다 오른쪽일 때
            if(num<left){
                // 2-2-1 바구니 위치를 왼쪽으로 이동
                answer += (left-num);
                left = num;
                right = left+(M-1);
            }
        }
        System.out.println(answer);
    }
}
