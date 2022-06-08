package BaekJoon.P2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2108
 * [2108번: 통계학]-Silver3
 */

public class Main {
    static int N;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        int sum = 0;
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(br.readLine());
            sum += list[i];
        }
        Arrays.sort(list);
        System.out.println((int)Math.round(((double)sum/N)));
        System.out.println(list[N/2]);
        System.out.println(manyValue());
        System.out.println((list[N-1]-list[0]));
    }
    static int manyValue(){
        int max = 0;
        int ans = 0;
        boolean check = false;
        for(int i=0;  i<N; i++){
            int value = list[i];
            int count = 1;
            for(int j=i+1; j<N; j++){
                if(value == list[j]){
                    i++;
                    count++;
                }else{
                    break;
                }
            }
            if(max < count){
                max = count;
                ans = value;
                check = true;
            }
            else if(max==count && check){ // 최빈값중 두 번째 작은것을 기억하면 되기 때문에 check 로 이번 최빈값이 두 번째인지 판별한다.
                ans = value;
                check = false;
            }
        }
        return ans;
    }
}
