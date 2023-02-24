package Programmers.호텔대실;

import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        List<Room> list = new ArrayList<>();
        for(int i=0; i<book_time.length; i++){
            int start = change(book_time[i][0]);
            int end = change(book_time[i][1]);
            list.add(new Room(start,end+10));
        }
        Collections.sort(list, (o1,o2)->{

            int com = Integer.compare(o1.start,o2.start);
            if(com==0) return Integer.compare(o1.end, o2.end);
            return com;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<list.size(); i++){
            Room room = list.get(i);
            if(pq.isEmpty()){
                pq.add(room.end);
                continue;
            }

            if(room.start >= pq.peek()){
                pq.poll();
            }
            pq.add(room.end);
        }
        return pq.size();
    }
    static int change(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
    static class Room{
        int start;
        int end;
        public Room(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
