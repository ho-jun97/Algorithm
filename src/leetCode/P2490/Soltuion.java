package leetCode.P2490;

class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] str = sentence.split(" ");
        char start = str[0].charAt(0);
        char last = str[0].charAt(str[0].length()-1);
        for(int i=1; i<str.length; i++){
            if(str[i].charAt(0)!=last) return false;
            last = str[i].charAt(str[i].length()-1);
        }
        return start==last;
    }
}
