package leetCode.leetCode171;

class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        int cal = 1;
        for(int i=columnTitle.length()-1; i>=0; i--){
            char c = columnTitle.charAt(i);
            ans += (c-'A'+1)*cal;
            cal *= 26;
        }
        return ans;
    }
}
