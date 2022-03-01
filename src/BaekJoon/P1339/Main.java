package BaekJoon.P1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.acmicpc.net/problem/1339
 * [1339번: 단어 수학]-Gold4
 */

public class Main {
    static int N;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new Integer[26];
        for(int i=0; i<arr.length; i++){
            arr[i] = 0;
        }
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<str.length(); j++){
                int num = str.charAt(j)-'A';
                arr[num] += (int)Math.pow(10,str.length()-j-1);
            }
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int sum=0;
        int num=9;
        for(Integer i : arr){
            if(i==0) break;
            sum += i*num;
            num--;
        }
        System.out.println(sum);
    }
}
