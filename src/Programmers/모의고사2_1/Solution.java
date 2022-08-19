package Programmers.모의고사2_1;

import java.util.*;
class Solution {
    static int count = 0;
    static boolean[] visited;
    static List<List<Integer>> list;
    public int solution(int[] number) {
        visited = new boolean[number.length];
        int answer = 0;
        list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        dfs(0,0,0,number, arr);
        return list.size();

    }

    static void dfs(int sum, int depth, int index, int[] number, List<Integer> arr){
        if(depth == 3){
            if(sum == 0){
                list.add(arr);
            }
            return;
        }
        for(int i=index; i<number.length; i++){
            arr.add(i);
            dfs(sum+number[i], depth+1, i+1, number, arr);
            arr.remove(Integer.valueOf(i));
        }
    }
}
