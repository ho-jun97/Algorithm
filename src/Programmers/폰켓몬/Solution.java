package Programmers.폰켓몬;

import java.util.*;
public class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length/2;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i : nums){
            hash.put(i, hash.getOrDefault(i,0) + 1);
        }
        int size = (hash.size());
        return size >= N ? N : size ;
    }
}
