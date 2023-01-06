package Programmers.뉴스클러스터링;

import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        // 대/소문자 구별없이 모두 대문자로 설정
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // str1 분리
        for(int i=0; i<str1.length()-1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if('A' <= c1 && c1 <= 'Z' && 'A' <= c2 && c2 <= 'Z'){
                String temp = str1.substring(i,i+2);
                s1.add(temp);
            }
        }

        //str2 분리
        for(int i=0; i<str2.length()-1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if('A' <= c1 && c1 <= 'Z' && 'A' <= c2 && c2 <= 'Z'){
                String temp = str2.substring(i,i+2);
                s2.add(temp);
            }
        }
        for(String s : s1){
            if(s2.remove(s)){ // true면 교집합
                intersection.add(s);
            }
            union.add(s);
        }
        // s2에 남아있는 원소들 합집합에 저장
        for(String s : s2){
            union.add(s);
        }
        double rate = 0;
        if(union.size()==0){
            rate = 1;
        }else{
            rate = (double)intersection.size() / (double)union.size();
        }
        answer = (int)(rate*65536);
        return answer;
    }
}
