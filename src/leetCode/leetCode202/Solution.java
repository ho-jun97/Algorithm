package leetCode.leetCode202;

class Solution {
    public boolean isHappy(int n) {
        while(n>9){
            int ans = 0;
            while(n>0){
                ans += (n % 10) * (n % 10);
                n /= 10;
            }
            n = ans;
            if(ans == 1){
                return true;
            }
        }
        if(n==1 || n == 7){
            return true;
        }
        return false;
    }
}
