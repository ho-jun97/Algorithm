package Programmers.괄호변환;

class Solution {
    public String solution(String p) {
        String answer = "";
        if(p.equals("")) return "";
        return split(p);
    }
    static String split(String w){

        if(w.equals("")) return "";
        String u = "";
        String v = "";
        int cnt = 0;
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) == '('){
                cnt--;
            }
            if(w.charAt(i) == ')'){
                cnt++;
            }

            if(cnt==0){
                u = w.substring(0,i+1);
                v = w.substring(i+1, w.length());

                if(check(u)){
                    u += split(v);
                }else{
                    String str = "(";
                    str += split(v);
                    str += ")";
                    str += reverse(u);
                    return str;
                }
                break;
            }
        }
        return u;
    }
    // u의 첫 번재와 마지막 문자 제거 후, 괄호 방향 뒤집는 함수
    static String reverse(String str){
        str = str.substring(1, str.length()-1);
        String s = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ')'){
                s += '(';
            }else{
                s += ')';
            }
        }
        return s;
    }
    // 올바른 괄호인지 판단하는 함수
    static boolean check(String p){
        int cnt = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == ')'){
                cnt--;
            }
            if(p.charAt(i) == '('){
                cnt++;
            }
            if(cnt < 0) return false;
        }
        return cnt==0;
    }
}
