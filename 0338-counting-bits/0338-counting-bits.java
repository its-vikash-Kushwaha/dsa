class Solution {
     public int countBit(int n) {
        int count=0;

        while(n>0){
            count+=(n&1);
            n=n>>1;
        }
        return count;
    }
    public int[] countBits(int n) {

        int ans[]=new int[n+1];

        for(int i=0;i<=n;i++){
            ans[i]=countBit(i);
        }
        return ans;
        
    }
}