package Programmers.등굣길;

class Solution {
    static int[][] map;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        map = new int[n+1][m+1];

        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            map[y][x] = -1;
        }
        map[1][1] = 1;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] == -1){ // 웅덩이 경우 0으로 바꾼다.
                    map[i][j] = 0;
                    continue;
                }
                if(i!=1){ // 첫 행이 아닐 때
                    map[i][j] += map[i-1][j] % 1000000007;
                }
                if(j!=1){ // 첫 열이 아닐 때
                    map[i][j] += map[i][j-1] % 1000000007;
                }
            }
        }
        answer = (map[n][m] % 1000000007);
        return answer;
    }
}
