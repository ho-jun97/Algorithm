package BaekJoon.P1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1213
 * [1213번: 팰린드롬 만들기]-Silver4
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String str = br.readLine();

        for(int i=0; i<str.length(); i++){
            alpha[str.charAt(i)-'A']++;
        }

        int midIndex = 0; // 중간에 위치해야할 인덱스
        int odd=0; // 홀수인 알파벳의 개수를 나타내는 변수

        for(int i=0; i<alpha.length; i++){
            if(alpha[i]%2 !=0){
                midIndex = i;
                odd++;
            }
        }

        // 문자열길이가 짝수이면 홀수개의 알파벳이 있으면 안됨
        // 물자열길이가 홀수이면 홀수개의 알파벳이 1개여야함
        int len = str.length();
        if((len%2==0 && odd>0) || (len%2!=0 && odd!=1)){
            System.out.println("I'm Sorry Hansoo");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<alpha.length; i++){
                for(int j=0; j<alpha[i]/2; j++){
                    sb.append((char)(i+'A'));
                }
            }
            String reverseStr = sb.reverse().toString();
            sb.reverse();
            if(odd==1){
                sb.append((char)(midIndex+'A'));
            }
            sb.append(reverseStr);
            System.out.println(sb.toString());
        }
    }}
