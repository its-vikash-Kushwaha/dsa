class Solution {
    public int getSum(int a, int b) {
        
       int sum=a^b;
       int carry=(a&b)<<1;

      while (carry != 0){
        int s=sum;
        sum=sum^carry;
        carry=(s&carry)<<1;

       }
       return sum;

      
    }
}