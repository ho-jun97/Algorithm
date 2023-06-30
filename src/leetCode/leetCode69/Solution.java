package leetCode.leetCode69;

class Solution {
    public int mySqrt(int x) {
        int r = x;
        int l = 1;


        while(l <= r){
            int mid = (l+r)/2;

            if(mid == x/mid){
                return mid;
            }else if(mid < x/mid){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }
}
