package Programmers.pccp모의고사2;

public class Solution {
    static int N,M;
    static boolean[] checked;
    static int max = Integer.MIN_VALUE;
    public int solution(int[][] ability) {
        N = ability.length;
        M = ability[0].length;
        checked = new boolean[N];
        dfs(0,0,ability);

        return max;
    }
    public void dfs(int depth, int sum, int[][] ability){
        if(depth == M){
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<N; i++){
            if(!checked[i]){
                checked[i] = true;
                dfs(depth+1, sum + ability[i][depth], ability);
                checked[i] = false;
            }
        }
    }
}