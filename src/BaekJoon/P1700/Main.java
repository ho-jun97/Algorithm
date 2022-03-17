package BaekJoon.P1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1700
 * [1700번: 멀티탭 스케줄링]-Gold1
 */

public class Main {
    static int N, K;
    static int[] arr;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍의 개수
        K = Integer.parseInt(st.nextToken()); // 용품의 총 사용횟수
        arr = new int[K];
        used = new boolean[101]; // 100개의 콘센트

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int multi=0;
        int answer = 0;
        for(int k=0; k<K; k++) {
            int con = arr[k];
            // 1. 사용하려는 콘센트가 꽂혀있는 경우 -> 아무것도 안해도 됨
            // 2. 사용하려는 콘센트가 꽂혀있지 않은 경우
            if(!used[con]){
                // 2-1 멀티탭이 사용 가능할 때 -> 그냥 사용하면 됨
                if(multi<N){
                    used[con] = true; // 사용
                    multi++;
                }
                // 2-2 멀티탭이 다 사용중일 때
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    for(int i=k; i<K; i++){ // 현재 사용중인 콘센트가 나중에도 사용하는지 확인
                        if(used[arr[i]] && !list.contains(arr[i])){
                            list.add(arr[i]);
                        }
                    }
                    if(list.size()==N){ // 현재 사용중인 콘센트가 모두 나중에 사용
                        used[list.get(list.size()-1)] = false; // 가장 마지막에 사용될 콘센트 제거
                    }else{
                        for(int i=0; i<K; i++){
                            if(used[arr[i]] && !list.contains(arr[i])){
                                used[arr[i]] = false;
                                break;
                            }
                        }
                    }
                    used[con] = true;
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
