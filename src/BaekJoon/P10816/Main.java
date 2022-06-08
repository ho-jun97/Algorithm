package BaekJoon.P10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10816
 * [10816번: 숫자 카드2]-Silver4
 */

public class Main {
    static int N,M;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            sb.append((upper_bound(num)-lower_bound(num))).append(" ");
        }
        System.out.println(sb.toString());
    }
    static int lower_bound(int num){
        int start = 0;
        int end = card.length;
        while(start<end){
            int mid = (start+end)/2;

            if(card[mid]>=num){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
    static int upper_bound(int num){
        int start = 0;
        int end = card.length;
        while(start<end){
            int mid = (start+end)/2;

            if(card[mid] > num){
                end = mid;
            }else{
                start = mid+1;
            }
        }

        return start;
    }
}
