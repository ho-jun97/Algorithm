package leetCode.leetCode190;

public class Solution {
    public int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        
        for(int i=str.length(); i<32; i++){
            str = "0" + str;
        }

        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();

        int ans = 0;
        int v = 1;
        for(int i=str.length()-1; i>=0; i--){
            ans += (str.charAt(i)-'0')*v;
            v*=2;
        }

        return ans;
    }
}
