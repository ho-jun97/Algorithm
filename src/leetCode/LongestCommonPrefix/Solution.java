package leetCode.LongestCommonPrefix;

import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int index = 0;

        Arrays.sort(strs);
        String ans = "";
        a: for(int i=0; i<strs[0].length(); i++){
            char std = strs[0].charAt(i);
            for(int j=0; j<strs.length; j++){
                if(std != strs[j].charAt(i)){
                    break a;
                }
            }
            ans += std;
        }
        return ans;
    }
}