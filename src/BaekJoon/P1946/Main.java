package BaekJoon.P1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1946
 * [1946번: 신입사원]-Sliver1
 */

public class Main {
    static int T;
    static class Person{
        int paper;
        int meet;
        boolean check;
        public Person(int paper, int meet, boolean check) {
            this.paper = paper;
            this.meet = meet;
            this.check = check;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int textCase=1; textCase<=T; textCase++){
            StringTokenizer st;
            int N  = Integer.parseInt(br.readLine());
            Person[] people = new Person[N];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken()); // 서류 성적
                int meet = Integer.parseInt(st.nextToken()); // 면접 성적
                people[i] = new Person(paper, meet, false);
            }
            Arrays.sort(people, new Comparator<Person>() { // 서류 성적에 대하여 오름차순 정렬
                @Override
                public int compare(Person o1, Person o2) {
                    return Integer.compare(o1.paper, o2.paper);
                }
            });
            int count=1;
            int min = people[0].meet; //
            for(int i=1; i<N; i++){
                if(min>people[i].meet){
                    min = people[i].meet;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
