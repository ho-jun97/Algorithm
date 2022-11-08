package Programmers.피로도;

class Solution {
    static boolean[] visited;
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        dfs(0,0,k,dungeons);
        return max;
    }
    static void dfs(int depth, int count, int k, int[][] dungeons){
        max = Math.max(max,count); // 최댓값 count 구하기
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){ // 방문하지 않았으면서 던전입장 조건에 만족할 때
                visited[i] = true;
                dfs(depth+1,count+1,k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
    }
}