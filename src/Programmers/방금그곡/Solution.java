package Programmers.방금그곡;

import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = -1;
        for(String music : musicinfos){
            String[] info = music.split(",");

            List<String> list = divide(info[3]);
            int len = list.size();
            int time = cal(info[1]) - cal(info[0]);
            List<String> value = new ArrayList<>();
            int index = 0;
            int temp = time;
            if(time > len){
                while(temp-- > 0){
                    value.add(list.get(index%len));
                    index++;
                }
            }
            else{
                value = list.subList(0,time);
            }
            // 해당 String이 포함되면서 최고 실행시간
            if(function(m, value) && max < time){
                answer = info[2];
                max = time;
            }
        }
        return answer;
    }
    // 포함되어있는지 검사하는 함수
    static boolean function(String m, List<String> list){
        List<String> target = divide(m);

        int index = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(target.get(index))){
                index++;
                if(index == target.size()) return true;
            }else{
                if(index != 0){
                    i--;
                    index = 0;
                }
            }
        }
        return false;
    }
    // 시간 계산
    static int cal(String t){
        String[] time = t.split(":");

        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
    // String을 List로 변환(C#, D#, F#, G#, A# 한 String으로 처리)
    static List<String> divide(String str){
        List<String> list = new ArrayList<>();
        String s = "";
        s += str.charAt(0);
        for(int i=1; i<str.length(); i++){
            char temp = str.charAt(i);
            if('A' > temp || temp > 'Z'){
                s += temp;
                continue;
            }
            list.add(s);
            s = "";
            s += temp;
        }
        list.add(s);
        return list;
    }

}
