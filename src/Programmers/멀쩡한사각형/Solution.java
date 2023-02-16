class Solution {
    static int gcd(int w, int h){
        if(w < h){
            int temp = w;
            w = h;
            h = temp;
        }
        while(h!=0){
            int temp = w%h;
            w = h;
            h = temp;
        }
        return w;
    }
    public long solution(int w, int h) {
        long answer = 1;
        long a = (long)w*(long)h;
        long b = (long)w+(long)h;
        long c = (long)gcd(w,h);
        return a-b+c;
    }
}
