package leetCode.leetCode290;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");
        // pattern과 단어 길이가 안맞으면 만족 x
        if(word.length != pattern.length()) return false;
        
        Set<String> set = new HashSet<>();
        String[] target = new String[26];

        for(int i=0; i<pattern.length(); i++){
            int index = pattern.charAt(i)-'a';
            if(target[index] == null){ // pattern은 다른데 동일한 값이 있으면 만족 x
                if(!set.add(word[i])){
                    return false;
                }
                target[index] = word[i];
                continue;
            }
            if(!target[index].equals(word[i])){ // 같은 pattern인데 단어가 다르면 만족 x
                return false;
            }
        }
        return true;
    }
}
