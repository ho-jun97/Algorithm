package Programmers.pccp모의고사1;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        int[] check = new int[26];

        char std = input_string.charAt(0);
        for(int i=1; i<input_string.length(); i++){
            if(std != input_string.charAt(i)){
                check[std-'a']++;
                std = input_string.charAt(i);
            }
        }
        check[std-'a']++;
        for(int i=0; i<26; i++){
            if(check[i] > 1){
                answer += (char)('a'+i);
            }
        }
        if(answer.length() == 0) return "N";
        return answer;
    }
}
