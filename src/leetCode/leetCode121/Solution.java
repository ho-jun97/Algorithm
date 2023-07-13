package leetCode.leetCode121;

class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];

        dp[0] = 0; // 처음은 차이가 없으므로 0
        int min = prices[0]; // 시작을 최소로 설정
        for(int i=1; i<dp.length; i++){
            min = Math.min(min, prices[i]); // 최소값 결정
            int value = prices[i]-min > 0 ? (prices[i]-min) : 0;
            dp[i] =  Math.max(dp[i-1],  value); // 지금까지 최댓값을 현재 dp에 저장
        }
        return dp[prices.length-1]; // 제일 마지막 값이 최댓값
    }
}
