package Programmers.JadenCase문자열만들기;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        for(String st : str){
            if(st.equals("")){
                answer += " ";
                continue;
            }
            answer += change(st);
            answer += " ";
        }
        if(s.substring(s.length()-1, s.length()).equals(" ")) return answer;
        return answer.substring(0, answer.length()-1);
    }
    static String change(String s){
        String temp = "";
        s = s.toLowerCase();
        temp += Character.toUpperCase(s.charAt(0));
        temp += s.substring(1);
        return temp;
    }
}
