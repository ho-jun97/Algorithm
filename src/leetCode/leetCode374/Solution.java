package leetCode.leetCode374;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 0;
        int end = n;
        int ans = -1;
        while(true){
            int mid = start + (end - start)/2;
            int val = guess(mid);

            switch(val){
                case 1 :
                    start = mid+1;
                    break;
                case -1 :
                    end = mid-1;
                    break;
                case 0 :
                    ans = mid;
            }
            if(ans != -1) break;
        }
        return ans;
    }
}
