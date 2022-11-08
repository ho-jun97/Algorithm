package Programmers.pccp모의고사3;

class Solution {
    static String[] info = {"RR","Rr","Rr","rr"};
    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        for(int i=0; i<queries.length; i++){
            answer[i] = dfs(queries[i][0], queries[i][1]);
        }
        return answer;
    }
    static String dfs(int n, int p){
        if(n==1) return "Rr";
        // 1. 부모가 누구인지
        String parent = dfs(n-1, (p-1)/4 + 1);
        // 1-1. 부모가 RR이거나 rr이면 부모 반환
        if(parent.equals("Rr")){
            return info[(p-1)%4];
        }
        // 1-2. 부모가 Rr이면 info[p+1 % 4] 반환
        else{
            return parent;
        }

    }
}
