package Programmers.단어변환;

class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[] checked;
    public int solution(String begin, String target, String[] words) {
        checked = new boolean[words.length];
        dfs(begin, target,0,words);
        if(answer == Integer.MAX_VALUE){
            answer = 0;
        }
        return answer;
    }
    static void dfs(String change, String target, int count, String[] words){
        if(change.equals(target)){
            answer = Math.min(answer, count);
            return;
        }else{
            for(int i=0; i<words.length; i++){
                if(!checked[i]){
                    if(check(change, words[i])){
                        checked[i] = true;
                        dfs(words[i], target, count+1, words);
                        checked[i] = false;
                    }
                }
            }
        }
    }
    // 한개를 바꾸면 같은지 확인하는 함수
    static boolean check(String a, String b){
        int cnt = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
            if(cnt>1){
                return false;
            }
        }
        return true;
    }
}
