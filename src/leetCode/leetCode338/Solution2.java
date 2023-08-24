package leetCode.leetCode338;

class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int std = 1;
        for(int i=1; i<=n; i++){
            if(std * 2 == i){
                std *= 2;
            }
            ans[i] = ans[i-std] + 1;
        }
        return ans;
    }
}
