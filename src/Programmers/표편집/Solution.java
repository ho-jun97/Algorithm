package Programmers.표편집;

import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> history = new Stack<>(); // 삭제햇을 때 정보들 저장
        int max_num = n-1;
        // cmd 구현
        for(int i=0; i<cmd.length; i++){
            String[] str = cmd[i].split(" ");
            char oper = str[0].charAt(0);
            switch(oper){
                case 'D':
                    k += Integer.parseInt(str[1]);
                    break;
                case 'U':
                    k -= Integer.parseInt(str[1]);
                    break;
                case 'C':
                    history.push(k); // 삭제 정보 저장
                    if(k==max_num){
                        k--;
                    }
                    max_num--;
                    break;
                case 'Z':
                    int num = history.pop();
                    if(num <= k){
                        k++;
                    }
                    max_num++;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=max_num; i++){
            sb.append("O");
        }
        while(!history.isEmpty()){
            int value = history.pop();
            sb.insert(value,'X');
        }
        answer = sb.toString();
        return answer;
    }

}
