package BaekJoon.P10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10814
 * [10814번: 나이순 정렬]-Sliver5
 */

public class Main {
    static int N;
    static class Person{
        int age;
        int inputNum;
        String name;

        public Person(int age, String name, int inputNum){
            this.age = age;
            this.name =name;
            this.inputNum = inputNum;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Person[] people = new Person[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = new Person(age,name,i);
        }
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int comp = Integer.compare(o1.age,o2.age); // 나이 기준으로 정렬
                if(comp==0){
                    return Integer.compare(o1.inputNum,o2.inputNum); // 나이가 같으면 입력순서대로
                }else{
                    return comp;
                }
            }
        });
        for(int i=0; i<N; i++){
            System.out.println(people[i].age + " " + people[i].name);
        }
    }
}
