package Programmers.퍽핟하자않은건물;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] map = new int[board.length+1][board[0].length+1];
        for(int[] info : skill){
            int r1 = info[1];
            int c1 = info[2];
            int r2 = info[3];
            int c2 = info[4];
            int degree = info[5] * (info[0]==1 ? -1:1);

            map[r1][c1] += degree;
            map[r1][c2+1] += -degree;
            map[r2+1][c1] += -degree;
            map[r2+1][c2+1] += degree;
        }
        // 상하 누적합
        for(int i=1; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                map[i][j] += map[i-1][j];
            }
        }
        // 좌우 누적합
        for(int i=1; i<board[0].length; i++){
            for(int j=0; j<board.length; j++){
                map[j][i] += map[j][i-1];
            }
        }
        // 누적합과 보드 합
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] + map[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}