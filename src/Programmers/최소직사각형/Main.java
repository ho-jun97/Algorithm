package Programmers.최소직사각형;

public class Main {
    static class Solution {
        public int solution(int[][] sizes) {
            int w = 0, h = 0;

            for(int i=0; i<sizes.length; i++){
                if(sizes[i][0] > sizes[i][1]){
                    int temp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = temp;
                }
                w = Math.max(w, sizes[i][0]);
                h = Math.max(h, sizes[i][1]);
            }
            return w * h;
        }
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(solution.solution(sizes));
    }
}

