package BaekJoon.P11497;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11497
 * [11497번: 통나무 건너뛰기]-Silver1
 */

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] temp = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int left = 0;
            int right = arr.length-1;
            for(int i=0; i<N; i++){
                if(i%2==0){ // left-> 시작은 왼쪽
                    temp[left++] = arr[i];
                }else{ // right
                    temp[right--] = arr[i];
                }
            }
            int answer = 0;
            for(int i=0; i<temp.length-1; i++){
                answer = Math.max(answer, Math.abs(temp[i]-temp[i+1]));
            }
            answer = Math.max(answer, Math.abs(temp[0]-temp[temp.length-1])); // (처음과 끝의 차이를 비교)
            System.out.println(answer);
        }

    }
}
