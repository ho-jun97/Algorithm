package BaekJoon.P10655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10655
 * [10655번: 마라톤 1]-Silver3
 */

public class Main {
    static int N;
    static Node[] list;
    static int dis=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new Node[N];
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[i] = new Node(x,y);
            if(i>0) {
                dis += Math.abs(list[i].x - list[i - 1].x) + Math.abs(list[i].y - list[i - 1].y);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=1; i<N-1; i++){
            int noSkip = Math.abs(list[i].x-list[i-1].x)+Math.abs(list[i].y-list[i-1].y)
                    + Math.abs(list[i].x-list[i+1].x)+Math.abs(list[i].y-list[i+1].y);

            int skip = Math.abs(list[i-1].x-list[i+1].x)+Math.abs(list[i-1].y-list[i+1].y);

            min = Math.min(min, dis-noSkip+skip);
        }
        System.out.println(min);
    }
    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
