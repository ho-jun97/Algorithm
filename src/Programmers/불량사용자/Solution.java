package Programmers.불량사용자;

import java.util.*;
class Solution {
    static boolean[] userVisited;
    static boolean[] banVisited;
    static HashSet<HashSet<String>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        userVisited = new boolean[user_id.length];
        banVisited = new boolean[user_id.length];
        HashSet<String> arr = new HashSet<>();
        dfs(0, user_id, banned_id, arr);
        answer = set.size();
        return answer;
    }
    static void dfs(int depth, String[] user_id, String[] banned_id, HashSet<String> arr){
        if(depth == banned_id.length){
            set.add(new HashSet<>(arr));
            return;
        }
        for(int i=0; i<user_id.length; i++){
            if(!userVisited[i]){
                if(check(user_id[i], banned_id[depth])){
                    userVisited[i] = true;
                    arr.add(user_id[i]);
                    dfs(depth+1, user_id, banned_id, arr);
                    arr.remove(user_id[i]);
                    userVisited[i] = false;
                }
            }
        }
    }
    static boolean check(String user, String ban){
        if(user.length() != ban.length()){ // 길이가 안맞으면 false
            return false;
        }
        for(int i=0; i<user.length(); i++){
            if(ban.charAt(i)=='*') continue;
            if(user.charAt(i) != ban.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
