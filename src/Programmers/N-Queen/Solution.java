package Programmers.N-Queen;

class Solution {
    static int[] board;
    static int ans;
    public int solution(int n) {
        ans = 0;
        board = new int[n];
        backTracking(0, n);
        
        return ans;
    }
    static void backTracking(int depth, int n){
        if(depth == n){
            ans++;
            return;
        }
        
        for(int i=0; i<n; i++){
            board[depth] = i;
            if(check(depth)){
                backTracking(depth+1, n);
            }
        }
    }
    static boolean check(int depth){
        for(int i=0; i<depth; i++){
            if(board[i] == board[depth]) return false;
            if(Math.abs(i-depth) == Math.abs(board[i] - board[depth])) return false;
        }
        return true;
    }
}
