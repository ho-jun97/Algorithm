package leetCode.leetCode67;

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length()-1;
        int bLen = b.length()-1;
        int up = 0;
        while(aLen >= 0 || bLen >= 0){
            int val = up;

            if(aLen >= 0){
                val += (a.charAt(aLen--)-'0');
            }
            if(bLen >= 0){
                val += (b.charAt(bLen--)-'0');
            }
            sb.append(val%2);
            up = (val/2);
        }
        if(up > 0){
            sb.append(up);
        }

        return sb.reverse().toString();
    }
}
