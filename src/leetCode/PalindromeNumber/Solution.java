package leetCode.PalindromeNumber;

public class Solution {
    public boolean isPalindrome(int x) {
        String xToString = String.valueOf(x);
        int startIndex = 0;
        int endIndex = xToString.length()-1;

        while(startIndex < endIndex){

            if(xToString.charAt(startIndex) != xToString.charAt(endIndex)){
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}
