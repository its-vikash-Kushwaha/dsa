class Solution {
    public int hammingDistance(int x, int y) {
        int s=x^y;

        int count=0;
        while(s>0){
            count+= (s&1);
            s=s>>1;
        }
        return count;
    }
}