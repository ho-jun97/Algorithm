package leetCode.leetCode344;

class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        char[] temp = new char[len];
        int index = 0;
        for(int i=len-1; i>=0; i--){
            temp[index++] = s[i];
        }
        for(int i=0; i<len; i++){
            s[i] = temp[i];
        }
    }
}
