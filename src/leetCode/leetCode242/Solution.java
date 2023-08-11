package leetCode.leetCode242;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];

        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            cnt[index]++;
        }
        for(int i=0; i<t.length(); i++){
            int index = t.charAt(i)-'a';
            cnt[index]--;
        }

        for(int i=0; i<26; i++){
            if(cnt[i] != 0){
                return false;
            }
        }
        return true;
    }
}
