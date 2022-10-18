package Programmers.pccp모의고사2;

import java.io.IOException;

public class Main {
    static int N,M;
    static boolean[] checked;
    static int max = Integer.MIN_VALUE;
    public static int solution(int[][] ability) {
        N = ability.length;
        M = ability[0].length;
        checked = new boolean[N];
        dfs(0,0,ability);

        return max;
    }
    public static void dfs(int depth, int sum, int[][] ability){
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

    public static void main(String[] args) throws IOException {
        // 예시
        int[][] ability = {{40,10,10}, {20,5,0}, {30,30,30} ,{70,0,70} ,{100,100,100}};
        System.out.println(solution(ability));

    }
}