package BaekJoon.P16967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16967
 * [16967번: 배열 복원하기]-Silver3
 */

public class Main {
    static int H,W,X,Y;
    static int[][] A;
    static int[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        A = new int[H][W];
        B = new int[H+X][W+Y];

        for(int i=0; i<H+X; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<W+Y; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<H+X; i++){
            for(int j=0; j<W+Y; j++){
                if(i<X && j < W){ // 겹치지 않는 위에 부분
                    A[i][j] = B[i][j];
                }else if(i<H && j<Y){ // 겹치는 않는 옆에 부분
                    A[i][j] = B[i][j];
                }
                else if(i >=X && j >= Y && i<H && j<W){ // 겹치는 부분
                    A[i][j] = B[i][j] - A[i-X][j-Y];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<H; i++){
            for (int j = 0; j < W; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
