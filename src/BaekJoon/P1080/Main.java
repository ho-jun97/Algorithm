package BaekJoon.P1080;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1080
 * [1080번: 행렬]-Silver1
 */

public class Main {
    static int N,M;
    static int[][] mapA;
    static int[][] mapB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mapA = new int[N+1][M+1];
        mapB = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                mapA[i][j]=(str.charAt(j-1)) - '0';
            }
        }

        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                mapB[i][j]=(str.charAt(j-1)) - '0';
            }
        }

        if(N<3 || M<3){ //  3x3 바꾸지 못하는 값일 때
            if(check()){ //  A와 B가 같은지
                System.out.println(0);
            }else { // 같지않으면 -1
                System.out.println(-1);
            }
            return;
        }


        int count=0;
        for(int i=1; i<=N; i++){ // 행렬을 돌면서 같지 않으면 뒤집기
            for(int j=1; j<=M; j++){
                if(mapA[i][j]!=mapB[i][j]){
                    change(i,j);
                    count++;
                }
            }
        }
        if(check()){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
    static boolean check(){ //  같은지 확인하기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(mapA[i][j] != mapB[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    static void change(int x, int y){ // 3x3 뒤집기
        if(x+2 >N || y+2>M){
            return;
        }
        for(int i=x; i<=x+2; i++){
            for(int j=y; j<=y+2; j++){
                mapA[i][j] = mapA[i][j]==0 ? 1 : 0;
            }
        }
    }
}
