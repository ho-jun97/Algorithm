package Programmers.숫자문자열과영단어;

class Solution {
    static String[] charNum = {"zero", "one", "two", "three", "four", "five", "six", "seven","eight","nine"};
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<=9; i++){
            s = s.replaceAll(charNum[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
