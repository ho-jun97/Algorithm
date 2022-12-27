package Programmers.방문길이;

class Solution {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,-1,0,1};
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] check = new boolean[11][11][4];

        char[] info = dirs.toCharArray();

        int x = 5;
        int y = 5;
        int index = 1;
        for(char c : info){
            int d = 0;
            if(c == 'U'){
                d = 0;
            }else if(c == 'L'){
                d = 1;
            }else if(c == 'D'){
                d = 2;
            }else{ // c == R
                d = 3;
            }
            int px = x + dx[d];
            int py = y + dy[d];

            if(0 <= px && px <= 10 && 0 <= py && py <= 10){
                if(!check[px][py][d]){
                    check[px][py][d] = true;
                    d = (d%2==0)? 2-d : 4-d;
                    check[x][y][d] = true;
                    answer++;
                }
                x = px;
                y = py;
            }
        }
        return answer;
    }
}
