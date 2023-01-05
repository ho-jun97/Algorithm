package Programmers.튜플;

import java.util.*;
class Solution {
    public int[] solution(String s) {
        // 불필요한 요소 제거 후 -로 구별
        s = s.substring(2,s.length()-2).replace("},{", "-");
        // 구혈하기 위해 바꾼 -로 문자열 나누기
        String[] str = s.split("-");
        // 길이에 따라 정렬
        Comparator.
        Arrays.sort(str, Comparator.comparingInt(String::length));
        List<Integer> list = new ArrayList<>();
        for(String st : str){
            String[] temp = st.split(",");
            for(String t : temp){
                int n = Integer.parseInt(t);
                if(!list.contains(n)) list.add(n);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}