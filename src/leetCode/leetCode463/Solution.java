package leetCode.leetCode463;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int islandPerimeter(int[][] grid) {     
        int h = grid.length;
        int w = grid[0].length;
        int ans = 0;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                int plus = 4;
                if(grid[i][j] == 1){
                    for(int k=0; k<4; k++){
                        int px = i + dx[k];
                        int py = j + dy[k];
                        if(0 <= px && px < h && 0 <= py && py < w){
                            if(grid[px][py] == 1){
                                plus--;
                            }
                        }
                    }
                    ans += plus;
                }
            }
        }
        return ans;
    }
}
