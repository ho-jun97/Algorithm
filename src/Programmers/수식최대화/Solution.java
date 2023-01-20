package Programmers.수식최대화;

import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Character> opers;
    static List<Long> nums;
    static List<Character> list;
    static long ans;
    public long solution(String expression) {
        list = new ArrayList<>();
        nums = new ArrayList<>();
        opers = new ArrayList<>();

        String num = "";
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(!('0' <= c && c <= '9')){
                if(!list.contains(c)){
                    list.add(c);
                }
                nums.add(Long.parseLong(num));
                num = "";
                opers.add(c);
            }else{
                num += c;
            }
        }
        nums.add(Long.parseLong(num));
        char[] c = new char[list.size()];
        visited = new boolean[list.size()];
        ans = 0;
        dfs(0,list,c);
        return ans;
    }
    static void dfs(int depth, List<Character> list, char[] c){
        if(depth == list.size()){
            ans = Math.max(ans,function(c));
            return;
        }
        for(int i=0; i<list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                c[depth] = list.get(i);
                dfs(depth+1, list, c);
                visited[i] = false;
            }
        }
    }
    static long function(char[] c){
        long sum = 0;
        List<Long> copyNum = new ArrayList<>(nums);
        List<Character> copyOper = new ArrayList<>(opers);
        for(char oper : c){

            for(int i=0; i<copyOper.size(); i++){
                if(oper == copyOper.get(i)){
                    long v = cal(copyNum.get(i),copyNum.get(i+1),oper);
                    copyNum.set(i,v);
                    copyNum.remove(i+1);
                    copyOper.remove(i);
                    i--;
                }
            }
        }
        return Math.abs(copyNum.get(0));
    }
    static long cal(long a, long b, char oper){
        long v = 0;
        if(oper == '*'){
            v = a * b;
        }
        if(oper == '-'){
            v = a-b;
        }
        if(oper == '+'){
            v = a+b;
        }
        return v;
    }
}
