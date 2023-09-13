class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0;
        for(int i=0; i<s.length(); i++){
            char std = s.charAt(i);
            int temp = index;
            for(int j=index; j<t.length(); j++){
                if(std == t.charAt(j)){
                    index = j+1;
                    break;
                }
            }
            if(index == temp){
                return false;
            }
        }
        return true;
    }
}
