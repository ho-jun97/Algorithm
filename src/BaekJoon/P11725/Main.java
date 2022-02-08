package BaekJoon.P11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11725
 * 트리의 부모 찾기 - Sliver2
 */

public class Main {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[] parents;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N+1];
        parents = new int[N+1];
        visited = new boolean[N+1];

        // 트리 초기화
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        // 노드 연결
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        // dfs 돌면서 부모노드 찾기
        for(int i=1; i<=N; i++){
            dfs(i);
        }
        for (int i = 2; i <=N; i++) {
            System.out.println(parents[i]);
        }
    }
    static void dfs(int x){
        if (visited[x]) { // 방문한 노드면 종료
            return;
        }else{
            visited[x] = true; // 방문처리
            for(int node : tree[x]){ // 연결된 노드 순회
                if(!visited[node]){ // 방문하지 않은 노드 선택
                    parents[node] = x; //  부모 설정
                    dfs(node);
                }
            }
        }
    }
}
