package leetCode.leetCode383;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> std = new HashMap<>();

        // 1. ransomNote 문자들 저장
        for(int i=0; i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            std.put(c, std.getOrDefault(c,0)+1);
        }

        // 2. key 확인 후 있으면 -1
        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            if(std.containsKey(c)){
                std.put(c, std.get(c)-1);
            }
        }

        // 3. key 확인했을 때 0 보다 크면 false
        for(Character c : std.keySet()){
            if(std.get(c) > 0) return false;
        }

        return true;
    }
}
