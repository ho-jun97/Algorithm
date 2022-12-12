package leetCode.P2502;

import java.util.Arrays;

class Allocator {
    private int[] arr;
    private int size;
    public Allocator(int n) {
        size = n;
        arr = new int[size];
    }

    public int allocate(int size, int mID) {
        if(size>arr.length) return -1;
        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        for(int i=0; i<this.size; i++){
            if(arr[i]!=0){
                count = 0;
                startIndex = i+1;
                continue;
            }
            count++;
            if(count == size){
                endIndex = i;
                break;
            }
        }
        if(startIndex > endIndex){
            return -1;
        }
        Arrays.fill(arr, startIndex, Math.min(endIndex+1, this.size), mID);
        return startIndex;
    }
    public int free(int mID) {
        int cnt = 0;
        for(int i=0; i<this.size; i++){
            if(arr[i] == mID){
                cnt++;
                arr[i] = 0;
            }
        }
        return cnt;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */