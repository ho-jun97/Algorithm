package BaekJoon.P1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1543
 * [1543번: 문서 검색]-Silver4
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int count=0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)==str2.charAt(0)){ // 시작 부분이 같을 때
                if(i+str2.length()<=str1.length()) { // index를 넘어가지 않을 때
                    if (str1.substring(i, i + str2.length()).equals(str2)) { // 비교할 문자열 크기만큼 짤랐을 때 같은 경우
                        count++; // 개수 추가
                        i += str2.length()-1; // 중복이 허락되지 않기 때문에
                    }
                }
            }
        }
        System.out.println(count);
    }
}
