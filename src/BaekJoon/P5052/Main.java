package BaekJoon.P5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/5052
 * [5052번: 전화번호 목록]-Gold4
 */

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            String[] arr = new String[N];
            for(int i=0; i<N; i++) { // 배열 저장
                arr[i] = (br.readLine());
            }
            Arrays.sort(arr); //  오름차순 정렬
            boolean check = false;
            for(int i=0; i<N-1; i++){
                if(arr[i+1].startsWith(arr[i])) { // startWith -> 시작 스트링 확인하는 함수
                    check = true;
                    break;
                }
            }
            if(check){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }
        }
    }
}
