package Programmers.쿼드압축후개수세기;

class Solution {
    static int zero;
    static int one;
    public int[] solution(int[][] arr) {
        zero = 0;
        one = 0;
        dfs(0,0,arr.length-1,arr[0].length-1,arr);
        return new int[]{zero,one};
    }
    public void dfs(int startX, int startY, int endX, int endY, int[][] arr){
        int std = arr[startX][startY];
        boolean check = true;

        a:for(int i=startX; i<=endX; i++){
            for(int j=startY; j<=endY; j++){
                if(std != arr[i][j]){
                    check = false;
                    break a;
                }
            }
        }
        if(check){
            if(std==0){
                zero++;
            }else{
                one++;
            }
            return;
        }
        dfs(startX, startY,  (startX+endX)/2, (startY+endY)/2, arr);
        dfs(startX, (startY+endY)/2+1, (startX+endX)/2, endY, arr);
        dfs((startX+endX)/2+1, startY, endX, (startY+endY)/2, arr);
        dfs((startX+endX)/2+1, (startY+endY)/2+1, endX, endY, arr);
    }
}
