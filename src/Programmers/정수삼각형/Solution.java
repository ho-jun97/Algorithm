package Programmers.정수삼각형;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0]; // 제일 첫번 값 설정
        for(int i=1; i<triangle.length; i++){
            dp[i][0] = triangle[i][0] + dp[i-1][0];

            for(int j=1; j< i+1; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
                if(i==triangle.length-1){ // 제일 밑이면 max 값 구하기
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer;
    }
}
