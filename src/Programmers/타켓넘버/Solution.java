package Programmers.타켓넘버;

class Solution {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        dfs(0,0,target,numbers);
        return answer;
    }
    static void dfs(int depth, int sum, int target, int[] numbers){
        if(depth == numbers.length){
            if(sum == target){
                answer++;
            }
            return;
        }
        dfs(depth+1, sum+numbers[depth], target, numbers);
        dfs(depth+1, sum-numbers[depth], target, numbers);
    }
}
