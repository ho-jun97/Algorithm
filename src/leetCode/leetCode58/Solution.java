package leetCode.leetCode58;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] str = s.trim().split(" ");
        return str[str.length-1].length();
    }
}
