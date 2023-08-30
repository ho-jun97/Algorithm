package leetCode.leetCode367;

class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        int s = 1;
        int e = num;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(mid *  mid == num) return true;
            else if(mid < num/mid){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return false;
    }
}
