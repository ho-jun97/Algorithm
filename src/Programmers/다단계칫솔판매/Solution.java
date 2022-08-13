package Programmers.다단계칫솔판매;

import java.util.*;
class Solution {
    static Node[] nodes;
    static Map<String, Integer> map;
    static int[] money;
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        nodes = new Node[enroll.length+1];
        map = new HashMap<>();
        money = new int[enroll.length+1];
        nodes[0] = new Node("-");
        map.put("-",0);
        for(int i=1; i<=enroll.length; i++){
            nodes[i] = new Node(enroll[i-1]);
            nodes[i].setParent(new Node(referral[i-1]));
            map.put(enroll[i-1],i);
        }
        for(int i=0; i<seller.length; i++){
            String name = seller[i];
            int value = amount[i]*100;
            dfs(nodes[map.get(name)], value);
        }
        answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = money[i+1];
        }
        return answer;
    }
    static void dfs(Node node, int value){
        if(node.name.equals("-")){ // 민호일 때
            return;
        }
        if((value*0.1) < 1){ // 10%가 1원보다 작을 때
            money[map.get(node.name)] += value;
            return;
        }

        money[map.get(node.name)] += value-(int)(value*0.1); // 10%를 뗀 가격
        dfs(nodes[map.get(node.parent.name)], (int)(value*0.1));
    }
    static class Node{
        String name;
        Node parent;
        public Node(String name){
            this.name = name;
            this.parent = null;
        }
        public void setParent(Node parent){
            this.parent = parent;
        }
    }

}
