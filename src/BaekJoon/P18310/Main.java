package BaekJoon.P18310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/18310
 * [18310번: 안테나]-Sliver3
 */

public class Main {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        if(N%2==0){
            System.out.println(list[(N/2-1)]);
        }else{
            System.out.println(list[N/2]);
        }
    }
}
