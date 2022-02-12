package BaekJoon.P10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10610
 * [10610번: 30]-Sliver5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        int[] list = new int[str.length()];
        int allSum = 0;
        for(int i=0; i<list.length; i++){
            list[i] = str.charAt(i)-'0'; // 자릿수
            allSum += list[i]; // 자릿수들의 합
        }

        Arrays.sort(list); // 오름차순 정렬

        StringBuilder sb = new StringBuilder();
        // 자릿수들의 합이 3의 배수이고, 0이 포함되어 있는지
        if(allSum%3==0 && list[0]==0){
            for(int i=list.length-1; i>=0; i--){
                sb.append(list[i]);
            }
        }else{
            sb.append(-1);
        }
        System.out.println(sb.toString());
    }
}
