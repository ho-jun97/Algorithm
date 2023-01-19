package Programmers.메뉴리뉴얼;

import java.util.*;
class Solution {
    static boolean[] visited;
    static int max;
    static List<String> answer;
    static HashMap<String,Integer> map;
    public String[] solution(String[] orders, int[] course) {
        answer = new ArrayList<>();

        // 문자들 오름차순 정렬하기
        for(int i=0; i<orders.length; i++){
            char[] c = orders[i].toCharArray();
            Arrays.sort(c);
            orders[i] = String.valueOf(c);
        }

        for(int i=0; i<course.length; i++){
            map = new HashMap<>();
            max = Integer.MIN_VALUE;
            for(String order : orders){
                visited = new boolean[order.length()];
                dfs(0,0,course[i],"", order);
            }
            for(String key : map.keySet()){
                // 최소 2명 이상
                if(max > 1 && map.get(key) == max){
                    answer.add(key);
                }
            }
        }
        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }
    static void dfs(int depth, int index, int N, String cur, String str){
        if(depth == N){
            map.put(cur, map.getOrDefault(cur,0)+1); // 해당하는 코스 저장
            max = Math.max(max, map.get(cur)); // 최댓값 저장
            return;
        }
        for(int i=index; i<str.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i, N, cur + str.charAt(i), str);
                visited[i] = false;
            }
        }
    }
}
