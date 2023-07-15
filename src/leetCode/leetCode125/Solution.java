package leetCode.leetCode125;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;

        while(l<r){
            char left = s.charAt(l);
            char right = s.charAt(r);
            if(!Character.isLetterOrDigit(left)){
                l++;
            }else if(!Character.isLetterOrDigit(right)){
                r--;
            }else{
                if(left != right){
                    return false;
                }   
                l++;
                r--;
            }
        }
        return true;
    }
}
