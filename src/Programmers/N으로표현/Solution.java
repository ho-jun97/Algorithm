package Programmers.N으로표현;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static int n,num;
    public int solution(int N, int number) {
        n = N;
        num = number;
        dfs(0,0);
        return answer==Integer.MAX_VALUE?-1:answer;
    }
    static void dfs(int cnt, int cur){
        if(cnt > 8){
            return;
        }
        if(cur == num){
            answer = Math.min(answer,cnt);
            return;
        }
        int temp = n;
        for(int i=0; i<8; i++){
            dfs(cnt+i+1, cur + temp);
            dfs(cnt+i+1, cur - temp);
            dfs(cnt+i+1, cur / temp);
            dfs(cnt+i+1, cur * temp);

            temp = temp * 10 + n;
        }
    }
}