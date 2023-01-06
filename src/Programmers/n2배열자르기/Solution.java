package Programmers.n2배열자르기;

import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> list  = new ArrayList<>();
        for(long i=left; i<=right; i++){
            list.add((int)Math.max(i/n,i%n)+1);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
