package Programmers.숫자변환하기;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[1000001];
        for(int i=0; i<1000001; i++){
            dp[i] = 1000000;
        }
        dp[x] = 0;
        for(int i=x; i<=y; i++){
            if(i+n <= y){
                dp[i+n] = Math.min(dp[i+n], dp[i]+1);
            }
            if(i*2 <= y){
                dp[i*2] = Math.min(dp[i*2], dp[i]+1);
            }
            if(i*3 <= y){
                dp[i*3] = Math.min(dp[i*3], dp[i]+1);
            }
        }
        return dp[y]==1000000?-1:dp[y];
    }
}
