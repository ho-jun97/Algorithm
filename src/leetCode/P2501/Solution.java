package leetCode.P2501;

import java.util.*;
class Solution {
    public int longestSquareStreak(int[] nums) {
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        for(int num : set){
            int count = 1;
            while(set.contains(num*num)){
                count++;
                num *= num;
            }
            max = Math.max(max,count);
        }
        return max==1?-1:max;

    }
}
