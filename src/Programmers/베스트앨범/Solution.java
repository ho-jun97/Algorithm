package Programmers.베스트앨범;

import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i],0) + plays[i]);
        }
        ArrayList<String> genreList = new ArrayList<>();
        for(String key : map.keySet()){
            genreList.add(key);
        }
        Collections.sort(genreList, (o1,o2)->Integer.compare(map.get(o2), map.get(o1))); // 총 play에 대해서 정렬

        ArrayList<Node> result = new ArrayList<>();
        for(String genre : genreList){

            ArrayList<Node> temp = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genre.equals(genres[i])){
                    temp.add(new Node(genres[i], plays[i], i));
                }
            }
            Collections.sort(temp, new Comparator<Node>(){
                @Override
                public int compare(Node n1, Node n2){
                    int com1 = Integer.compare(n2.play,n1.play);
                    if(com1 == 0){
                        return Integer.compare(n1.index, n2.index); // 플레이 수가 같으면 index 낮은 순
                    }
                    return com1; // 플레이 높은 순 정렬
                }
            });
            result.add(temp.get(0));
            if(temp.size()!=1){
                result.add(temp.get(1));
            }
        }
        answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).index;
        }
        return answer;
    }
    static class Node{
        String name;
        int play;
        int index;
        public Node(String name, int play, int index){
            this.name = name;
            this.play = play;
            this.index = index;
        }
    }
}
