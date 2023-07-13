package leetCode.leetCode121;

class Solution2 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for(int i=0; i<prices.length; i++){
            min = Math.min(min, prices[i]);
            int value = prices[i] - min;
            ans = Math.max(ans, value);
        }
        return ans;
    }
}
