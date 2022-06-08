package BaekJoon.P10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10825
 * [10825번: 국영수]-Silver4
 */

public class Main {
    static int N;
    static ArrayList<Student> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Student student = new Student(name,k,e,m);
            list.add(student);
        }
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int com1 = Integer.compare(o2.korea,o1.korea);
                if(com1==0){
                    int com2 = Integer.compare(o1.english,o2.english);
                    if(com2==0){
                        int com3 = Integer.compare(o2.math,o1.math);
                        if(com3==0){
                            return o1.name.compareTo(o2.name);
                        }
                        return com3;
                    }
                    return com2;
                }
                return com1;
            }
        });
        for(Student s : list){
            System.out.println(s.name);
        }
    }
    static class Student{
        String name;
        int korea;
        int english;
        int math;

        public Student(String name, int korea, int english, int math) {
            this.name = name;
            this.korea = korea;
            this.english = english;
            this.math = math;
        }
    }
}
