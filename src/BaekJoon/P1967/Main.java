package BaekJoon.P1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1967
 * [1967번: 트리의 지름]-Gold4
 */

public class Main {
    static int N;
    static ArrayList<Node>[] tree;
    static int max = Integer.MIN_VALUE;
    static int max_idx = Integer.MIN_VALUE;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree[a].add(new Node(b,v));
            tree[b].add(new Node(a,v));
        }

        // 1부터 가중치를 더했을 때 제일 큰 값의 index를 찾기
        visited = new boolean[N+1];
        visited[1] = true;
        dfs(1,0);

        // 그 인덱스부터 더해가면서 max 찾기
        visited = new boolean[N+1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);

    }
    static void dfs(int x, int value){
        if(max < value){
            max = value;
            max_idx = x;
        }
        for(Node next : tree[x]){
            if(!visited[next.num]){
                visited[next.num] = true;
                dfs(next.num, value+next.value);
            }
        }
    }
    static class Node{
        int num;
        int value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}
