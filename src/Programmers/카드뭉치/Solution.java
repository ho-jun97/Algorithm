package Programmers.카드뭉치;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        // goal 기준으로 왼쪽 확인, 오른쪽 확인
        int index = 0;
        int left = 0;
        int right = 0;
        while(index < goal.length){
            if(left < cards1.length && cards1[left].equals(goal[index])){
                left++;
                index++;
            }else if(right < cards2.length && cards2[right].equals(goal[index])){
                right++;
                index++;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
