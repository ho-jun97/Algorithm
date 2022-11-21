package Programmers.도둑질;

import java.util.*;
class Solution {
    public int solution(int[] money) {
        int len = money.length;
        int[] dp0 = new int[len];
        int[] dp1 = new int[len];
        dp0[0] = dp0[1] =money[0];
        dp1[1] = money[1];
        for(int i=2; i<len; i++){
            dp0[i] = Math.max(dp0[i-1], dp0[i-2]+money[i]);
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
        }
        return Math.max(dp0[len-2],dp1[len-1]);
    }
}