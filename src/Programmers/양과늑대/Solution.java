package Programmers.양과늑대;

import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = Integer.MIN_VALUE;
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;
        dfs(1,0,edges, info);
        return answer;
    }
    static void dfs(int sheep, int wolf, int[][] edges, int[] info){
        if(sheep <= wolf){
            return;
        }
        answer = Math.max(sheep,answer);
        for(int[] node : edges){
            int parent = node[0];
            int child = node[1];
            if(visited[parent] && !visited[child]){
                visited[child] = true;
                if(info[child]==0){
                    dfs(sheep+1, wolf, edges, info);
                }else{
                    dfs(sheep, wolf+1, edges, info);
                }
                visited[child]=false;
            }
        }
    }
}
