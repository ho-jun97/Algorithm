package leetCode.leetCode345;

class Solution {
    public String reverseVowels(String s) {
        List<Integer> index = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            sb.append(c);
            if(vowel(c)){
                index.add(i);
            }
        }

        int right = index.size()-1;
        int left = 0;

        while(left < right){
            sb.setCharAt(index.get(left), s.charAt(index.get(right)));
            sb.setCharAt(index.get(right), s.charAt(index.get(left)));
            left++;
            right--;
        }

        return sb.toString();
    }

    static boolean vowel(char val){
        return (val == 'a' || val == 'e' || val == 'i' || val == 'o' || val == 'u'
        || val == 'A' || val == 'E' || val == 'I' || val == 'O' || val == 'U');
    }
}
