package Programmers.가장큰정사각형;

class Solution
{
    static int[] dx = {0,-1,-1};
    static int[] dy = {-1,0,-1};
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] map = new int[board.length+1][board[0].length+1];
        for(int i=1; i<=board.length; i++){
            for(int j=1; j<=board[0].length; j++){
                map[i][j] = board[i-1][j-1];
            }
        }
        // 1이었을 때 상, 좌, 왼쪽 대각선 확인하여 최소의 +1
        for(int i=1; i<=board.length; i++){
            for(int j=1; j<=board[0].length; j++){
                if(map[i][j] == 1){
                    int min = 1000;
                    for(int k=0; k<3; k++){
                        int px = i + dx[k];
                        int py = j + dy[k];
                        min = Math.min(min,map[px][py]);
                    }
                    map[i][j] = min+1;
                    answer = Math.max(answer,map[i][j]);
                }
            }
        }
        return answer*answer;
    }
}
