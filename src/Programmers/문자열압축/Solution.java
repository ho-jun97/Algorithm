package Programmers.문자열압축;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if(s.length()==1) return 1;
        for(int i=1; i<s.length(); i++){
            String str = "";
            String temp = "";
            int count = 1;
            for(int j=0; j<s.length()/i; j++){
                if(temp.equals(s.substring(j*i,j*i+i))){
                    count++;
                    continue;
                }

                if(count >1){
                    str += count+temp;
                    count = 1;
                }else{
                    str += temp;
                }

                temp = s.substring(i*j, i*j+i);
            }
            // 마지막 배열까지
            if(count >1){
                str += count+temp;
            }else{
                str += temp;
            }
            // 나눠 떨어지지 않을 때 나머지 문자열 더하기
            if(s.length()%i != 0){
                str += s.substring(s.length()-s.length()%i);
            }
            answer = Math.min(answer, str.length());
        }
        return answer;
    }
}
