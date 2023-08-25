package leetCode.leetCode344;

class Solution {
    public void reverseString(char[] s) {
        
        for(int l=1; l<s.length; l++){
            for(int i=0; i<s.length-l; i++){
                char temp = s[i];
                s[i] = s[i+1];
                s[i+1] = temp;
            }
        }

    }
}
