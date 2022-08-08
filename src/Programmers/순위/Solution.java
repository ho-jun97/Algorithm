package Programmers.순위;

class Solution {
    static int WIN = 1;
    static int LOSE = -1;
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<results.length; i++){
            dp[results[i][0]][results[i][1]] = WIN;
            dp[results[i][1]][results[i][0]] = LOSE;
        }
        // 플로이드 와샬 알고리즘 (A > B , B > C 결론 :  A > C)
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(dp[i][k] == WIN && dp[k][j] == WIN){
                        dp[i][j] = WIN;
                        dp[j][i] = LOSE;
                    }
                    if(dp[i][k] == LOSE && dp[k][j] == LOSE){
                        dp[i][j] = LOSE;
                        dp[j][i] = WIN;
                    }
                }
            }
        }
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(dp[i][j] != 0) count++;
            }
            if(count == n-1){
                answer++;
            }
        }
        return answer;
    }
}
