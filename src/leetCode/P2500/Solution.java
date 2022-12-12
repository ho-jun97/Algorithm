package leetCode.P2500;

class Solution {
    public int deleteGreatestValue(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] check = new boolean[m][n];
        int answer = 0;
        for(int i=0; i<n; i++){
            int max = 0;
            for(int j=0; j<m; j++){
                int ma = 0;
                int index = 0;
                for(int k=0; k<n; k++){
                    if(check[j][k]) continue;
                    if(ma < grid[j][k]){
                        ma = grid[j][k];
                        index = k;
                    }
                }
                check[j][index] = true;
                max = Math.max(max,ma);
            }
            answer += max;
        }
        return answer;
    }
}