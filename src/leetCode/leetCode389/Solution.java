class Solution {
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        char ans = ' ';
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i)-'a']--;
        }
        for(int i=0; i<t.length(); i++){
            count[t.charAt(i)-'a']++;
        }
        for(int i=0; i<count.length; i++){
            if(count[i]!=0){
                ans = (char)('a'+i);
                break;
            }
        }
        return ans;
    }
}
