package BaekJoon.P16918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16918
 * [16918번: 봄버맨]-Silver1
 */

public class Main {
    static int R,C,N;
    static char[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] times;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];
        times = new int[R+1][C+1];

        for(int i=1; i<=R; i++){
            String str = br.readLine();
            for(int j=1; j<=C; j++){
                map[i][j] = str.charAt(j-1);
                if(map[i][j] == 'O'){
                    times[i][j] = 3;
                }
            }
        }
        search();
        print();
    }
    static void search(){
        int time=0;
        while(true) {
            if(time>=N) break;
            time++;
            // 폭탄이 설치 되어 있지 않은 모든 칸에 폭탄 설치
            if(time%2==0) {
                add(time);
            }else { // 터져야할 폭탄을 찾아서 파괴한다.
                for (int i = 1; i <= R; i++) {
                    for (int j = 1; j <= C; j++) {
                        if (times[i][j] == time) {
                            map[i][j] = '.'; // 해당 폭탄 파괴
                            times[i][j] = 0; // 시간 초기화
                            for (int k = 0; k < 4; k++) { // 상 하 좌 우 확인
                                int px = i + dx[k];
                                int py = j + dy[k];
                                if (px > 0 && py > 0 && px <= R && py <= C) {
                                    // 폭탄이면서 시간이 되지 않은 폭탄
                                    if(map[px][py]=='O' && times[px][py]!=time) {
                                        map[px][py] = '.';
                                        times[px][py] = 0;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    // 출력
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                sb.append((map[i][j]));
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
    // 폭탄 아닌 곳에 폭탄 설치하기
    static void add(int time){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(map[i][j]=='.'){
                    map[i][j]='O';
                    times[i][j] = time+3;
                }
            }
        }
    }
}
