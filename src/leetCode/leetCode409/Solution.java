package leetCode.leetCode409;

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[52];
        for(int val : s.toCharArray()){
            if('a' <= val && val <= 'z'){
                count[val-'a']++;
            }else{
                count[val+26-'A']++;
            }
        }
        int sum = 0;
        boolean check = false;
        for(int i=0; i<52; i++){
            if(count[i]%2==1) check = true;
            sum += (count[i]/2)*2;
        }
        if(check) sum++;
        return sum;
    }
}
