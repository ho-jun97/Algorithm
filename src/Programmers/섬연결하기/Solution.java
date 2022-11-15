package Programmers.섬연결하기;

import java.util.*;

class Solution {
    static int[] group;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        group = new int[n];
        // 그룹 초기화
        for(int i=0; i<n; i++){
            group[i] = i;
        }
        // cost에 따른 정렬
        Arrays.sort(costs, (o1,o2)-> Integer.compare(o1[2],o2[2]));
        for(int i=0; i<costs.length; i++){
            int a = find(costs[i][0]);
            int b = find(costs[i][1]);
            int cost = costs[i][2];

            if(a == b) continue; // 같은 부모인데 연결하면 사이클이 생기기 때문에 continue;
            union(a,b);
            answer += cost;
        }
        return answer;
    }
    // 그룹 찾는 함수
    public int find(int x){
        if(group[x] == x){
            return x;
        }
        return group[x]=find(group[x]);
    }
    // 그룹 합치는 함수
    public void union(int a, int b){
        int groupA = find(a);
        int groupB = find(b);

        if(groupA > groupB){
            group[groupA] = groupB;
        }else{
            group[groupB] = groupA;
        }
    }
}
