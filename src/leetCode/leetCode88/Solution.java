package leetCode.leetCode88;

import java.util.*;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 1. 첫번째 풀이 방식
        int[] ans = new int[m+n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while(index1 < m && index2 < n){
            if(nums1[index1] > nums2[index2]){
                ans[index++] = nums2[index2++];
            }else{
                System.out.println(index);
                ans[index++] = nums1[index1++];
            }
        }
        while(index1 < m){
            ans[index++] = nums1[index1++];
        }
        while(index2 < n){
            ans[index++] = nums2[index2++];
        }
        for(int i=0; i<m+n; i++){
            nums1[i] = ans[i];
        }

        // 2. 두 번째 투포인터 방식으로 풀이
//        int index1 = m-1;
//        int index2 = n-1;
//        int index = m+n-1;
//
//        while(index2 >= 0){
//            if(index1 >= 0 && nums1[index1] > nums2[index2]){
//                nums1[index--] = nums1[index1--];
//            }else{
//                nums1[index--] = nums2[index2--];
//            }
//        }
    }
}