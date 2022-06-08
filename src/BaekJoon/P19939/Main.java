package BaekJoon.P19939;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/19939
 * [19939번: 박 터뜨리기]-Silver5
 */

public class Main {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int ball = N;
        for(int i=1; i<=K; i++){
            ball -= i;
            if(ball<0){
                break;
            }
        }
        if(ball>=0){
            if(ball%K>0){
                System.out.println(K);
            }else{
                System.out.println(K-1);
            }
        }else{
            System.out.println(-1);
        }

    }
}
