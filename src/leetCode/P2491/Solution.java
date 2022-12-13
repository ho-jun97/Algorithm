package leetCode.P2491;

import java.util.*;
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int right = skill.length-1;
        int left = 0;
        int point = skill[left] + skill[right];
        long sum = skill[left++] * skill[right--];;

        while(left < right){
            int temp = skill[left] + skill[right];
            if(point != temp) return -1;
            sum += (skill[left++] * skill[right--]);
        }
        return sum;
    }
}