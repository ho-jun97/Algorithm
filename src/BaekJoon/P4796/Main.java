package BaekJoon.P4796;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4796
 * [4796번: 캠핑]-Sliver5
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int Count=1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 사용할 수 있는 일수
            int P = Integer.parseInt(st.nextToken()); // 캠핑장을 연속하는 일수
            int V = Integer.parseInt(st.nextToken()); // 휴가 일수
            if(L==0 && P==0 && V==0){
                break;
            }
            int answer = (V/P)*L + Math.min((V%P),L);
            System.out.println("Case "+Count+": "+ answer);
            Count++;
        }
    }
}
