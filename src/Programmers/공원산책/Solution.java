package Programmers.공원산책;

class Solution {
    static char[][] map;
    static int N,M;
    static int X, Y;
    public int[] solution(String[] park, String[] routes) {
        N = park.length;
        M = park[0].length();
        map = new char[N][M];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                char c = park[i].charAt(j);
                map[i][j] = c;
                if(c == 'S'){
                    X = i;
                    Y = j;
                }
            }
        }
        for(String route : routes){
            System.out.println(X + ", " + Y);
            char dir = route.charAt(0);
            int move = route.charAt(2)-'0';
            
            s:switch(dir){
                case 'N':
                    if(X - move < 0){
                        break;
                    }
                    for(int i=1; i<=move; i++){
                        if(map[X-i][Y] == 'X'){
                            break s;
                        }
                    }
                    X -= move;
                    break;
                case 'S':
                    if(X+move >= N){
                        break;
                    }
                    for(int i=1; i<=move; i++){
                        if(map[X+i][Y] =='X'){
                            break s;
                        }
                    }
                    X += move;
                    break;
                case 'W':
                    if(Y-move < 0){
                        break;
                    }
                    for(int i=1; i<=move; i++){
                        if(map[X][Y-i] =='X'){
                            break s;
                        }
                    }
                    Y -= move;
                    
                    break;
                case 'E':
                    if(Y+move >= M){
                        break;
                    }
                    for(int i=1; i<=move; i++){
                        if(map[X][Y+i] =='X'){
                            break s;
                        }
                    }
                    
                    Y += move;
                    break;
            }
        }
        return new int[]{X,Y};
    }
}
