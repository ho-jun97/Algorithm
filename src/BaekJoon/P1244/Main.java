package BaekJoon.P1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1244
 * [1244번: 스위치 켜고 끄기]-Sliver3
 */

public class Main {
    static int N,K;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int FM = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(FM==1){ //남자인 경우
                for(int j=num; j<=N; j+=num){
                    list[j-1] = list[j-1]^1;
                }
            }else{ // 여자인 경우
                int left = num - 1;
                int right = num + 1;
                while(true) {
                    if (left - 1 >= 0 && right - 1 < N) {
                        if (list[left - 1] == list[right - 1]) {
                            list[left-1] ^=1;
                            list[right-1]^=1;
                            left--;
                            right++;
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }
                list[num-1] ^=1;
            }
        }
        for(int i=1; i<=N; i++) {
            System.out.print(list[i-1]+" ");
            if(i%20==0){
                System.out.println();
            }
        }
    }

}
