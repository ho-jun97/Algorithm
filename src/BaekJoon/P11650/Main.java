package BaekJoon.P11650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11650
 * [11650번: 좌표 정렬하기]-Sliver5
 */

public class Main {
    static int N;
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(x,y);
        }
        Arrays.sort(nodes,new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int com = Integer.compare(o1.x, o2.x);
                if(com==0){
                    return Integer.compare(o1.y,o2.y);
                }else{
                    return com;
                }
            }
        });
        for(int i=0; i<N; i++){
            System.out.println(nodes[i].x + " " + nodes[i].y);
        }
    }
}
