package Programmers.이진변환반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int c = 0;
        int cnt = 0;
        while(!s.equals("1")){
            c += count(s);
            s = s.replaceAll("0","");
            int len = s.length();
            s = Integer.toBinaryString(len);
            cnt++;
        }
        return new int[]{cnt,c};
    }
    static int count(String s){
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                cnt++;
            }
        }
        return cnt;
    }
}