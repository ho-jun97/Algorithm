package Programmers.대충만든자판;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        // 1. targets 해당 문자가
        for(int i=0; i<targets.length; i++){
            // 2. keymap에 문자열중에 포함되는지 확인
            int sum = 0;
            boolean check = true;
            for(int j=0; j<targets[i].length(); j++){
                // 2.1 keymap에 있을 경우 클릭 횟수 구하고 최소 정하기
                int ans = Integer.MAX_VALUE;
                int c = 0;
                for(int k=0; k<keymap.length; k++){
                    String s = String.valueOf(targets[i].charAt(j));
                    int index = keymap[k].indexOf(s);
                    if(index == -1) continue;
                    c++;
                    ans = Math.min(ans,index+1);
                }
                if(c == 0){
                    check = false;
                    break;
                }
                sum += ans;
            }
            answer[i] = check ? sum : -1;
        }
        return answer;
    }
}
