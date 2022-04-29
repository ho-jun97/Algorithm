package BaekJoon.P1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1987
 * [1987번: 알파벳]-Gold4
 */

public class Main {
    static int R,C;
    static char[][] map;
    static int[] mx = {-1,1,0,0};
    static int[] my = {0,0,-1,1};
    static int ans;
    static ArrayList<Character> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R+1][C+1];

        for(int i=1; i<=R; i++){
            String str = br.readLine();
            for(int j=1; j<=C; j++){
                map[i][j] = str.charAt(j-1);
            }
        }
        arr = new ArrayList<>();
        dfs(1,1);
        System.out.println(ans);
    }
    static void dfs(int x, int y){
        if(arr.contains(map[x][y])){
            ans = Math.max(ans,arr.size());
            return;
        }else {
            arr.add(map[x][y]);
            for (int i = 0; i < 4; i++) {
                int px = x + mx[i];
                int py = y + my[i];
                if (px > 0 && py > 0 && px <= R && py <= C) {
                    dfs(px, py);
                }
            }
            arr.remove(arr.size() - 1);
        }
    }
}
