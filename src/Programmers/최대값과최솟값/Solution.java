package Programmers.최대값과최솟값;

import java.util.*;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] a = new int[str.length];
        for(int i=0; i<str.length; i++){
            a[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a);
        return a[0] + " " + a[a.length-1];
    }
}
