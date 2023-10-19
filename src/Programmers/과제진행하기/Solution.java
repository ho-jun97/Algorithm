package Programmers.과제진행하기;

import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        
        PriorityQueue<Plan> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.start, o2.start));
        Stack<Plan> wait = new Stack<>();
        for(int i=0; i<plans.length; i++){
            String sub = plans[i][0];
            int s = time(plans[i][1]);
            int p = Integer.parseInt(plans[i][2]);
            
            Plan plan = new Plan(sub,s,p);
            pq.add(plan);
        }
        List<String> ans = new ArrayList<>();
        Plan cur = pq.poll();
        while(!pq.isEmpty()){
            // 지금 현재 플레이시간이 다음을 넘는지 

            Plan next = pq.poll();
            // 1. cur가 끝나는 시간
            int curEnd = cur.start + cur.playTime;
            
            // 2. 현재 과제 플레이 시간에 겹치는게 없는 경우
            if(curEnd > next.start){
                cur.playTime = (curEnd - next.start);
                wait.add(cur);
                cur = next;
                continue;
            }
            ans.add(cur.subject);
            // 대기중인 과제가 있는경우
            while(!wait.isEmpty()){
                Plan w = wait.pop();
                int remain = next.start - curEnd;
                
                if(w.playTime <= remain){
                    ans.add(w.subject);
                    curEnd += w.playTime;
                }else{
                    w.playTime = w.playTime - remain; 
                    wait.add(w);
                    break;
                }
            }
            cur = next;
        }
        ans.add(cur.subject);
        while(!wait.isEmpty()){
            ans.add(wait.pop().subject);
        }
        
        return ans.toArray(new String[ans.size()]);
    }
    
    static int time(String t){
        String[] temp = t.split(":");
        
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }
    
    static class Plan{
        String subject;
        int start;
        int playTime;
        public Plan(String subject, int start, int playTime){
            this.subject = subject;
            this.start = start;
            this.playTime = playTime;
        }
    }
}
