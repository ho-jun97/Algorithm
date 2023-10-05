package leetCode.leetCode459;

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        
        for(int i=1; i<=s.length()/2; i++){
            String val = s.substring(0,i);
            boolean check = true;
            for(int j=i; j<s.length(); j+=i){
                int len = j+i > s.length() ? s.length() : j+i;
                String temp = s.substring(j,len);
                if(!val.equals(temp)){
                    check = false;
                    break;
                }
            }
            if(check){
                return true;
            }
        }
        return false;
    }
}
