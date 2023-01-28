package Programmers.문자열나누기;

class Solution {
    public int solution(String s) {
        int answer = 0;

        int firstCnt = 0;
        int exception = 0;
        char first = s.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(firstCnt == exception){
                answer++;
                first = s.charAt(i);
            }
            if(s.charAt(i) == first){
                firstCnt++;
            }else{
                exception++;
            }
        }
        return answer;
    }
}