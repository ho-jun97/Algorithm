package Programmers.여행경로;

import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<String> answers;
    public String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(answers);
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    static void dfs(int depth, String cur, String list, String[][] tickets){
        if(depth == tickets.length){
            answers.add(list);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(cur)){
                visited[i] = true;
                dfs(depth+1, tickets[i][1], list+" "+ tickets[i][1], tickets);
                visited[i] = false;
            }
        }

    }
}
