package Programmers.마법의엘레베이터;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String s = String.valueOf(storey);
        char[] temp = s.toCharArray();
        int[] values = new int[temp.length];
        for(int i=0; i<temp.length; i++){
            values[i] = temp[i] - '0';
        }

        for(int i=values.length-1; i>=0; i--){
            int value = values[i];
            if(value == 10){
                if(i-1 < 0){
                    answer +=1;
                    continue;
                }
                values[i-1]++;
                continue;
            }
            if(value >= 6){
                answer += (10-value);
                if(i-1 < 0){
                    answer +=1;
                    continue;
                }
                values[i-1]++;
            } else if(value <=4){
                answer += value;
            } else {
                if(i-1 < 0){
                    answer += value;
                    continue;
                }
                if(values[i-1] >= 5){
                    values[i-1]++;
                }
                answer += value;
            }
        }
        return answer;
    }
}
