package BaekJoon.P14466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14466
 * [14466번: 소가 길을 건너간 이유 6]-Gold4
 */

public class Main {
    static int N,K,R;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 목초지 크기
        K = Integer.parseInt(st.nextToken()); // 소 마리수
        R = Integer.parseInt(st.nextToken()); // 인접한 목초지 개수

        map = new int[N+1][N+1];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
        }
        ArrayList<Node> cawList = new ArrayList<>();

    }
    static class Node{
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
