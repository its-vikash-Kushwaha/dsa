class Solution {
    public int maxSubArray(int[] nums) {
             if(nums.length==1)return nums[0];

        int sum=Integer.MIN_VALUE;
         int p=Integer.MIN_VALUE;
        for(int i:nums){
          
          if(0>sum){
              sum=i;
              p=Math.max(p,sum);
              continue;
          }

          sum+=i;
          p=Math.max(p,sum);
        }
         return p;
    }
   
}