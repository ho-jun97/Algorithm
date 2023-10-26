package Programmers.바탕화면정리;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};
        int len = Math.max(wallpaper.length, wallpaper[0].length());
        int startX=len, startY=len, endX=0, endY=0;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                char c = wallpaper[i].charAt(j);
                if(c == '#'){
                    startX = Math.min(startX,i);
                    startY = Math.min(startY,j);
                    endX = Math.max(endX,i+1);
                    endY = Math.max(endY,j+1);
                }
            }
        }
        answer = new int[]{startX,startY,endX,endY};
        return answer;
    }
}
