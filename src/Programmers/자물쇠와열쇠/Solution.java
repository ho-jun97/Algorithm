package Programmers.자물쇠와열쇠;

public class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int point = key.length - 1;
        for(int x = 0; x < point + lock.length; x++) { //처음으로 겹치는 부분 + 자물쇠의 크기.
            for(int y = 0; y < point + lock.length; y++) {
                for(int r = 0; r < 4; r++) { //key를 회전한다.
                    int[][] extendArr = new int[lock.length + key.length * 2][lock.length + key.length * 2]; //확장
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            extendArr[i + point][j + point] = lock[i][j]; //확장할 배열 초기화
                        }
                    }
                    match(extendArr, key, r, x, y);  //newLock배열에 key배열을 더해준다
                    if(check(extendArr, point, lock.length)) return true; //자물쇠 영역이 모두 유효한 값인지 확인
                }
            }
        }
        return false;
    }

    public boolean check(int[][] arr, int point, int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(arr[point + i][point + j] != 1) return false;
            }
        }
        return true;
    }
    public void match(int[][] arr, int[][] key, int rot, int x, int y) {
        int n = key.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(rot == 0) { //한 번도 회전하지 않았을 때
                    arr[x + i][y + j] += key[i][j];
                } else if(rot == 1) { //90도
                    arr[x + i][y + j] += key[j][n - i - 1];
                } else if(rot == 2) { //180도
                    arr[x + i][y + j] += key[n - i - 1][n- j - 1];
                } else { //270도 회전한 경
                    arr[x + i][y + j] += key[n - j - 1][i];
                }
            }
        }
    }
}

