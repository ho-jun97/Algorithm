package Programmers.신규아이디추천;

class Solution {
    public String solution(String new_id) {
        // 1. 소문자 치환
        new_id = new_id.toLowerCase();
        // 2. 소문자, 숫자, 빼기, 밑줄, 마침표만 남기기
        new_id = new_id.replaceAll("[^0-9a-z._-]", "");
        // 3 .가 2번 연속 부분 하나의 .로
        new_id = new_id.replaceAll("[.]{2,}",".");
        // 4. . 처음이나 끝에 위차하면 제거
        new_id = new_id.replaceAll("^[.]|[.]$","");
        // 5. new_id가 빈 문자열이면 a 대입
        new_id = new_id.isEmpty()? "a": new_id;
        // 6. new_id의 길이가 16 이상이면 15개 표현
        if(new_id.length() >= 16){
            new_id = new_id.substring(0,15);
        }
        new_id = new_id.replaceAll("[.]$","");
        // 7. 길이가 2 이하이면 길이를 3이 될때까지
        while(new_id.length()<3){
            new_id += new_id.charAt((new_id.length()-1));
        }
        return new_id;
    }
}
