package Programmers.주차요금계산;

import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        HashMap<String, Integer> inCar = new HashMap<>();
        HashMap<String, Integer> fee = new HashMap<>();
        for(String record :  records){
            fee.put(record.split(" ")[1], 0);
        }
        for(String record : records){
            String[] info = record.split(" ");
            int time = Integer.parseInt(info[0].split(":")[0])*60 + Integer.parseInt(info[0].split(":")[1]);
            String number = info[1];
            String option = info[2];
            if(!inCar.containsKey(number)){
                // 1. 들어간 시간 알아내기 -> In 일때 배열에 넣기
                inCar.put(number, time);
            }else{
                // 2. 나온 시간 알아내기 -> Out일 때 In에서 검색 후 In에서 제거
                int startTime = inCar.remove(number);
                int endTime = time;

                fee.replace(number, fee.get(number) + endTime - startTime);

            }
        }
        // 3. 나오지 않은 사람 확인 -> In에 있는 차들 확인
        int std = 23*60 + 59;
        for(String key : inCar.keySet()){
            int startTime = inCar.get(key);

            fee.replace(key, fee.get(key)+ std - startTime);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList(fee.entrySet());
        Collections.sort(list, (o1,o2) -> Integer.compare(Integer.parseInt(o1.getKey()), Integer.parseInt(o2.getKey())));
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            if(list.get(i).getValue() > fees[0]){
                answer[i] = fees[1] + (int)Math.ceil((list.get(i).getValue() - fees[0]) / (double)fees[2]) * fees[3];
            }else{
                answer[i] = fees[1];
            }
        }
        return answer;
    }
}
