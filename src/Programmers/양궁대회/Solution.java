package Programmers.양궁대회;

class Solution {
    static int[] lion;
    static int[] res = {-1};
    static int max = Integer.MIN_VALUE;
    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info,0, n);
        int[] answer = {};

        return res;
    }
    static void dfs(int[] info, int depth, int n){
        if(depth == n){ // 라이언이 화살 다 쐈을 경우
            int apeachPoint = 0;
            int lionPoint = 0;
            for(int i=0; i<11; i++){
                if(info[i] != 0 || lion[i] != 0){ // 둘다 0이 아닐 경우
                    if(info[i] < lion[i]){ // lion이 더 많이 맞췄을 경우
                        lionPoint += 10-i;
                    }else{ // apeach가 더 많이 맞췄을 경우
                        apeachPoint += 10-i;
                    }
                }
            }
            if(lionPoint > apeachPoint){ // 라이언이 이겼을 경우
                if(lionPoint - apeachPoint >= max){ // 큰 점수 차이로 우승하는 경우
                    res = lion.clone();
                    max = lionPoint - apeachPoint;
                }
            }
            return;
        }else{
            for(int i=0; i<11 && lion[i] <= info[i]; i++){ // lion이 apeach한테 지고 있는 상황만 dfs 돌린다
                lion[i]++;
                dfs(info, depth+1, n);
                lion[i]--;
            }
        }
    }
}
