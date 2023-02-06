package Programmers.콜라문제;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n>=a){
            int cnt = ((n/a)*b);
            answer += cnt;
            n = cnt + n%a;
        }
        return answer;
    }
}