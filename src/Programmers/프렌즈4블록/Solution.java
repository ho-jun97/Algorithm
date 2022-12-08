package Programmers.프렌즈4블록;

class Solution {
    static int[] dx ={1,0,1};
    static int[] dy ={0,1,1};
    static char[][] map;
    static int M,N;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        map = new char[m][n];
        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
        while(true){
            boolean[][] check = new boolean[m][n];
            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(map[i][j] == '.') continue;
                    blockCheck(check,i,j);
                }
            }
            int cnt = blockDelete(check);
            if(cnt==0){
                break;
            }
            answer+=cnt;
            blockDown();
        }
        return answer;
    }
    // 블럭 내리기
    static void blockDown(){
        for(int c = 0 ; c < N ; c++) {
            for(int r = M - 1 ; r >= 0 ; r--) {
                if(map[r][c] == '.') {
                    for(int k = r - 1 ; k >= 0 ; k--) {
                        if(map[k][c] != '.') {
                            map[r][c] = map[k][c];
                            map[k][c] = '.';
                            break;
                        }
                    }
                }
            }
        }

    }
    // 블럭 지우기
    static int blockDelete(boolean[][] check){
        int cnt = 0;
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(check[i][j]){
                    map[i][j] = '.';
                    cnt++;
                }
            }
        }
        return cnt;
    }
    // 지워야할 블럭 찾기
    static void blockCheck(boolean[][] check,int x, int y){
        int cnt = 0;
        for(int i=0; i<3; i++){
            int px = x + dx[i];
            int py = y + dy[i];
            if(0<=px && px < M && 0<=py && py<N){
                if(map[x][y] == map[px][py]){
                    cnt++;
                }
            }
        }
        if(cnt==3){
            check[x][y] = true;
            check[x+1][y] = true;
            check[x][y+1] = true;
            check[x+1][y+1] = true;
        }
    }

}
