import java.util.*;
class Solution {
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int ans;
    public int solution(int n, String[] data) {
        ans = 0;
        boolean[] v = new boolean[8];
        dfs(0,"",v,data);
      
        return ans;
    }
    static boolean check(String arr, String[] data){
        for(String d : data){
            int dis = Math.abs(arr.indexOf(d.charAt(0)) - arr.indexOf(d.charAt(2))); // 간격
            char op = d.charAt(3); // 수식
            int range = d.charAt(4) - '0'; // 범위
            
            if(op == '='){
                if(!(dis == range+1)) return false;
            }else if(op == '>'){
                if(!(dis > range+1)) return false;
            }else if(op == '<'){
                if(!(dis < range+1)) return false;
            }
        }
        return true;
    }
    static void dfs(int cnt, String arr, boolean[] visited, String[] data){
        if(cnt == 7){
            if(check(arr, data)){
                ans++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                String name = arr + friends[i];
                dfs(cnt+1, name, visited, data);
                visited[i] = false;
            }
        }
    }
    
}
