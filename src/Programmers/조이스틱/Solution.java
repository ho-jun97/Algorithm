package Programmers.조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int min = name.length()-1;
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);
            if(ch-'A' > 13){
                answer += ('Z' - ch + 1);
            }else{
                answer += ch-'A';
            }

            int next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }
            min = Math.min(min, i*2 + name.length() - next);
            min = Math.min(min, i + (name.length() - next) * 2);
        }
        return answer+min;
    }
}