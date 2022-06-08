package BaekJoon.P11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11403
 * [11403번: 경로 찾기]-Silver1
 */

public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int k=1; k<=N; k++){ // 거쳐가는 노드
            for(int i=1; i<=N; i++){ //  출발 노드
                for(int j=1; j<=N; j++){ // 도착 노드
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for (int j = 1; j <= N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}
