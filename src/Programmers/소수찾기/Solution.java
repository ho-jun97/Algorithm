package Programmers.소수찾기;

import java.util.*;
class Solution {
    static Set<Integer> set;
    static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        char[] arr = numbers.toCharArray();
        visited = new boolean[arr.length];
        dfs(0,arr,"");
        return set.size();
    }

    static void dfs(int depth, char[] arr, String str){
        if(!str.equals("")){
            int num = Integer.parseInt(str);
            if(isPrime(num)){
                set.add(num);
            }
        }
        if(depth == arr.length){
            return;
        }
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, arr, str + arr[i]);
                visited[i] = false;
            }
        }
    }

    static boolean isPrime(int num){
        if(num<=1) return false;
        if(num==2) return true;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
