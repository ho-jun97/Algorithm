package Programmers.오픈채팅방;

import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hash = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(String s : record){
            String[] str = s.split(" ");
            if(str[0].equals("Enter")){
                hash.put(str[1],str[2]);
            }
            if(str[0].equals("Change")){
                hash.put(str[1],str[2]);
            }
        }

        for(String s : record){
            String[] str = s.split(" ");
            if(str[0].equals("Enter")){
                String temp = hash.get(str[1])+"님이 들어왔습니다.";
                list.add(temp);
            }
            if(str[0].equals("Leave")){
                String temp = hash.get(str[1])+"님이 나갔습니다.";
                list.add(temp);
            }
        }
        return list.toArray(String[]::new);
    }
}
