package BaekJoon.P7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7568
 * [7568번: 덩치]-Silver5
 */

public class Main {
    static int N;
    static Person[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N =  Integer.parseInt(br.readLine());
        arr = new Person[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            arr[i] = new Person(w,l);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int count=0;
            for(int j=0; j<N; j++){
                if(arr[i].weight < arr[j].weight && arr[i].length < arr[j].length){
                    count++;
                }
            }
            sb.append((count+1)).append(" ");
        }
        System.out.println(sb.toString());
    }
    static class Person{
        int weight;
        int length;

        public Person(int weight, int length) {
            this.weight = weight;
            this.length = length;
        }
    }
}
