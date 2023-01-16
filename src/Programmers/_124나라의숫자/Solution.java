package Programmers._124나라의숫자;

class Solution {
    static String[] info = {"1","2","4"};
    public String solution(int n) {
        String answer = "";
        while(n>0){
            int b = (n-1)%3;
            n = (n-1)/3;
            answer = info[b] + answer;
        }
        return answer;
    }
}
