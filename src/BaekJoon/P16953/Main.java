package BaekJoon.P16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16953
 * [16953번: A -> B]-Silver1
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = (st.nextToken());
        String B = (st.nextToken());
        int count=1;
        while(!B.equals(A)){ // A와 B가 같아지면 종료
            if(Integer.parseInt(B) < Integer.parseInt(A)){ //B가 A보다 작아지면 만들어질 수 없음
                count = -1;
                break;
            }
            if(B.charAt(B.length()-1)!='1' && Integer.parseInt(B)%2!=0){ // 2로 나누어지지도 끝이 1이 아니면 만들어질 수 없음
                count = -1;
                break;
            }
            if(B.charAt(B.length()-1)=='1'){ //  1을 제거한다.
                B = B.substring(0,B.length()-1);
            }else{ //  2를 나눈다
                int temp = Integer.parseInt(B);
                temp /= 2;
                B = Integer.toString(temp);
            }
            count++;
        }
        System.out.println(count);
    }
}
