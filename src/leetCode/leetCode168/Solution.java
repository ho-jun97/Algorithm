package leetCode.leetCode168;

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder  sb = new StringBuilder();
        while(columnNumber-- > 0){
            int value = (columnNumber)%26;
            sb.insert(0, (char)('A' + value));
            columnNumber /= 26;
        }
        return sb.toString();
    }
}
